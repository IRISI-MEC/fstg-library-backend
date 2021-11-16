package com.mec.libapi.application.converter.BookModule;

import com.mec.libapi.application.dto.bookModule.SpecialityDto;
import com.mec.libapi.domain.pojo.bookModule.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("SpecialityAppConverter")
public class SpecialityConverter {

    @Autowired
    @Qualifier("BookAppConverter")
    BookConverter bookConverter;

    public Speciality toPojo(SpecialityDto specialityDto) {
        Speciality speciality = new Speciality();
        speciality.setId(Long.parseLong(specialityDto.getId()));
        speciality.setLabel(specialityDto.getLabel());
        return speciality;
    }

    public SpecialityDto toDto(Speciality speciality, Boolean convertBooks) {

        SpecialityDto specialityDto = SpecialityDto.builder()
                .id(speciality.getId().toString())
                .label(speciality.getLabel())
                .build();

        if (convertBooks)
            speciality.getBooks().forEach(book -> specialityDto.getBooks().add(bookConverter.toDto(book, false, false)));

        return specialityDto;
    }
}
