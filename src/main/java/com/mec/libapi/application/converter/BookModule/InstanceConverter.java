package com.mec.libapi.application.converter.BookModule;

import com.mec.libapi.application.dto.bookModule.InstanceDto;
import com.mec.libapi.domain.pojo.bookModule.Instance;
import com.mec.libapi.util.AvailabilityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component("InstanceAppConverter")
public class InstanceConverter {

    @Autowired
    @Qualifier("BookAppConverter")
    BookConverter bookConverter;
    @Autowired
    @Qualifier("NCaseAppConverter")
    NCaseConverter nCaseConverter;
    @Autowired
    @Qualifier("DetailAppConverter")
    DetailConverter detailConverter;

    public Instance toPojo(InstanceDto instanceDto) {

        Instance instance = new Instance();
        instance.setId(Long.parseLong(instanceDto.getId()));
        instance.setEditor(instanceDto.getEditor());
        instance.setEdition(instanceDto.getEdition());
        instance.setInventoryNumber(Long.parseLong(instanceDto.getInventoryNumber()));
        instance.setLanguage(instanceDto.getLanguage());
        instance.setQrCode(instanceDto.getQrCode());
        // expected DateString 2021-12-01
        instance.setPublishingDate(LocalDate.parse(instanceDto.getPublishingDate()));
        instance.setPrice(Double.parseDouble(instanceDto.getPrice()));
        instance.setAvailability(AvailabilityUtil.getAvailability(Integer.parseInt(instanceDto.getAvailability())));
        instance.setBook(bookConverter.toPojo(instanceDto.getBook()));
        instance.setnCase(nCaseConverter.toPojo(instanceDto.getNCase()));
        instance.setDetail(detailConverter.toPojo(instanceDto.getDetailDto()));
        return instance;

    }

    public InstanceDto toDto(Instance instance, Boolean convertBook, Boolean convertNCase) {

        InstanceDto instanceDto = InstanceDto.builder()
                .id(instance.getId().toString())
                .editor(instance.getEditor())
                .edition(instance.getEdition())
                .inventoryNumber(instance.getInventoryNumber().toString())
                .language(instance.getLanguage())
                .qrCode(instance.getQrCode())
                .publishingDate(instance.getPublishingDate().toString())
                .price(instance.getPrice().toString())
                .detailDto(detailConverter.toDto(instance.getDetail()))
                .build();

        if (convertBook)
            instanceDto.setBook(bookConverter.toDto(instance.getBook(), false, true));

        if (convertNCase)
            instanceDto.setNCase(nCaseConverter.toDto(instance.getnCase(), false));

        return instanceDto;
    }
}
