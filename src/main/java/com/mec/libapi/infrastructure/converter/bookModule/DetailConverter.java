package com.mec.libapi.infrastructure.converter.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Detail;
import com.mec.libapi.infrastructure.entity.bookModule.DetailEntity;
import org.springframework.stereotype.Component;

@Component("DetailInfConverter")
public class DetailConverter {

    public DetailEntity toEntity(Detail detail) {
        return DetailEntity.builder()
                .id(detail.getId())
                .buyType(detail.getBuyType())
                .state(detail.getCondition())
                .deliverySlip(detail.getDeliverySlip())
                .provider(detail.getProvider())
                .build();
    }

    public Detail toPojo(DetailEntity detailEntity) {
        Detail detail = new Detail();
        detail.setId(detailEntity.getId());
        detail.setBuyType(detailEntity.getBuyType());
        detail.setCondition(detailEntity.getState());
        detail.setDeliverySlip(detailEntity.getDeliverySlip());
        detail.setProvider(detailEntity.getProvider());
        return detail;
    }

}
