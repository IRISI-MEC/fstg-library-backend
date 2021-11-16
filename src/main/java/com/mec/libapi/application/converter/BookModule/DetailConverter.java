package com.mec.libapi.application.converter.BookModule;

import com.mec.libapi.application.dto.bookModule.DetailDto;
import com.mec.libapi.domain.pojo.bookModule.Detail;
import org.springframework.stereotype.Component;

@Component("DetailAppConverter")
public class DetailConverter {

    public Detail toPojo(DetailDto detailDto) {
        Detail detail = new Detail();
        detail.setId(Long.parseLong(detailDto.getId()));
        detail.setBuyType(detailDto.getBuyType());
        detail.setCondition(detailDto.getCondition());
        detail.setDeliverySlip(detailDto.getDeliverySlip());
        detail.setProvider(detailDto.getProvider());
        return detail;
    }

    public DetailDto toDto(Detail detail) {
        return DetailDto.builder()
                .id(detail.getId().toString())
                .buyType(detail.getBuyType())
                .condition(detail.getCondition())
                .deliverySlip(detail.getDeliverySlip())
                .provider(detail.getProvider())
                .build();
    }

}
