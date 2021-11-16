package com.mec.libapi.application.dto.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Instance;
import com.mec.libapi.domain.pojo.bookModule.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;
    private String isbn;
    private String title;
    private String author;
    private String description;
    private SpecialityDto speciality;

    private List<InstanceDto> instances;

}
