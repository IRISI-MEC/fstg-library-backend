package com.mec.libapi.infrastructure.converter.userModule;

import com.mec.libapi.domain.pojo.userModule.CanBook;
import com.mec.libapi.domain.pojo.userModule.Fine;
import com.mec.libapi.infrastructure.entity.userModule.CanBookEntity;
import com.mec.libapi.infrastructure.entity.userModule.FineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CanBookInfConverter")
public class CanBookConverter {

    @Qualifier("FineInfConverter")
    @Autowired
    private FineConverter fineConverter;

    public CanBookEntity to(CanBook canBook) {
        List<FineEntity> fineEntities = new ArrayList<>();
        canBook.getUserFines().forEach(fine -> fineEntities.add(fineConverter.to(fine)));
        return CanBookEntity.builder()
                .id(canBook.getId())
                .firstName(canBook.getFirstName())
                .secondName(canBook.getSecondName())
                .email(canBook.getEmail())
                .password(canBook.getPassword())
                .overDue(canBook.getOverDue())
                .maxBooking(canBook.getMaxBooking())
                .userFines(fineEntities)
                .build();
    }

    public CanBook toPOJO(CanBookEntity canBookEntity) {
        CanBook canBook = new CanBook();
        canBook.setId(canBookEntity.getId());
        canBook.setFirstName(canBook.getFirstName());
        canBook.setSecondName(canBook.getSecondName());
        canBook.setEmail(canBook.getEmail());
        canBook.setPassword(canBook.getPassword());
        canBook.setOverDue(canBook.getOverDue());
        canBook.setMaxBooking(canBook.getMaxBooking());

        List<Fine> fines = new ArrayList<>();
        canBookEntity.getUserFines().forEach(fineEntity -> fines.add(fineConverter.toPOJO(fineEntity)));
        canBook.setUserFines(fines);

        return canBook;
    }
}
