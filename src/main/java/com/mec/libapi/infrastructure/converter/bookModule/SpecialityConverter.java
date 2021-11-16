package com.mec.libapi.infrastructure.converter.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.infrastructure.entity.bookModule.SpecialityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("SpecialityInfConverter")
public class SpecialityConverter {

    @Autowired
    @Qualifier("BookInfConverter")
    BookConverter bookConverter;

    public SpecialityEntity toEntity(Speciality speciality, Boolean convertBooks) {
        SpecialityEntity specialityEntity = SpecialityEntity.builder()
                .id(speciality.getId())
                .label(speciality.getLabel())
                .build();

        if (convertBooks)
            speciality.getBooks().forEach(book -> specialityEntity.getBookEntities().add(bookConverter.toEntity(book, false, true)));

        return specialityEntity;
    }

    public Speciality toPojo(SpecialityEntity specialityEntity, Boolean convertBooks) {
        Speciality speciality = new Speciality();

        speciality.setId(specialityEntity.getId());
        speciality.setLabel(specialityEntity.getLabel());

        if (convertBooks)
            specialityEntity.getBookEntities().forEach(bookEntity -> speciality.getBooks().add(bookConverter.toPojo(bookEntity, false, false)));

        return speciality;
    }
}
