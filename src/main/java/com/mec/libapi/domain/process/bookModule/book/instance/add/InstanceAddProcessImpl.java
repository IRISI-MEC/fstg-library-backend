package com.mec.libapi.domain.process.bookModule.book.instance.add;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.pojo.bookModule.Detail;
import com.mec.libapi.domain.pojo.bookModule.Instance;
import com.mec.libapi.domain.pojo.bookModule.NCase;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.bookModule.BookFacade;
import com.mec.libapi.infrastructure.dao.facade.bookModule.DetailFacade;
import com.mec.libapi.infrastructure.dao.facade.bookModule.InstanceFacade;
import com.mec.libapi.infrastructure.dao.facade.bookModule.NCaseFacade;
import com.mec.libapi.util.Availability;
import com.mec.libapi.util.AvailabilityUtil;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class InstanceAddProcessImpl extends AbstractProcessImpl<InstanceAddInput> implements InstanceAddProcess {

    private InstanceFacade instanceFacade;
    private BookFacade bookFacade;
    private NCaseFacade nCaseFacade;
    private DetailFacade detailFacade;

    private static Pattern DATE_PATTERN = Pattern.compile(
            "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
                    + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                    + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

    public InstanceAddProcessImpl(InstanceFacade instanceFacade, BookFacade bookFacade, NCaseFacade nCaseFacade, DetailFacade detailFacade) {
        this.instanceFacade = instanceFacade;
        this.bookFacade = bookFacade;
        this.nCaseFacade = nCaseFacade;
        this.detailFacade = detailFacade;
    }

    @Override
    public void validate(InstanceAddInput input, Result result) {
        Book book = bookFacade.findById(input.getBookId());
        if (book == null) result.addErrorMessage("Book does not exist");
        NCase nCase = nCaseFacade.findById(input.getnCaseId());
        if (nCase == null) result.addErrorMessage("Case does not exist");
        if (input.getPrice() <= 0) result.addErrorMessage("Incorrect price");
        if (input.getInventoryNumber() <= 0) result.addErrorMessage("Invalid inventory number");
        Availability availability = AvailabilityUtil.getAvailability(input.getAvailability());
        if (availability == null) result.addErrorMessage("Unknown availability");

        if (input.getPublishingDate() != null)
            if (!DATE_PATTERN.matcher(input.getPublishingDate()).matches())
                result.addErrorMessage("Invalid date format");
            else if (LocalDate.now().isAfter(LocalDate.parse(input.getPublishingDate())))
                result.addErrorMessage("Publishing date cannot be in the future");

        Instance instanceWithSameQrCode = instanceFacade.findByQrCode(input.getQrCode());
        if (instanceWithSameQrCode != null) result.addErrorMessage("Qr code already assigned");

        Detail detail = detailFacade.findByAllAttributes(input.getDetail().getBuyType().toLowerCase(), input.getDetail().getCondition().toLowerCase(), input.getDetail().getDeliverySlip().toLowerCase(), input.getDetail().getProvider().toLowerCase());

        if (detail == null)
            result.addInfoMessage("New detail entry provided");

    }

    @Override
    public void run(InstanceAddInput input, Result result) {
        Book book = bookFacade.findById(input.getBookId());
        NCase nCase = nCaseFacade.findById(input.getnCaseId());
        Instance instance = new Instance();
        instance.setBook(book);
        instance.setnCase(nCase);
        instance.setPrice(input.getPrice());
        instance.setQrCode(input.getQrCode());
        instance.setEditor(input.getEditor());
        instance.setEdition(input.getEdition());
        instance.setLanguage(input.getLanguage());
        instance.setInventoryNumber(input.getInventoryNumber());
        instance.setAvailability(AvailabilityUtil.getAvailability(input.getAvailability()));
        instance.setPublishingDate(LocalDate.parse(input.getPublishingDate()));

        Detail detail = detailFacade.findByAllAttributes(input.getDetail().getBuyType().toLowerCase(), input.getDetail().getCondition().toLowerCase(), input.getDetail().getDeliverySlip().toLowerCase(), input.getDetail().getProvider().toLowerCase());

        if (detail != null)
            instance.setDetail(detail);
        else
            // TODO -->  we have to communicate this process with detail process
            instance.setDetail(new Detail(null, input.getDetail().getBuyType().toLowerCase(), input.getDetail().getCondition().toLowerCase(), input.getDetail().getDeliverySlip().toLowerCase(), input.getDetail().getProvider().toLowerCase()));
    }

}
