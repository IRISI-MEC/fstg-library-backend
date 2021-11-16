package com.mec.libapi.application.dto.bookModule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialityDto {

    private String id;
    private String label;

    private List<BookDto> books;

}
