package com.mec.libapi.application.dto.bookModule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailDto {

    private String id;
    private String condition;
    private String buyType;
    private String provider;
    private String deliverySlip;

}
