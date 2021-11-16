package com.mec.libapi.application.dto.bookModule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstanceDto {

    private String id;
    private String qrCode;
    private String inventoryNumber;
    private String editor;
    private String edition;
    private String publishingDate;
    private String language;
    private String price;
    private String availability;

    private BookDto book;
    private NCaseDto nCase;
    private DetailDto detailDto;

}
