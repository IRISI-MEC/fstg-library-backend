package com.mec.libapi.infrastructure.converter.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Instance;
import com.mec.libapi.infrastructure.entity.bookModule.InstanceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("InstanceInfConverter")
public class InstanceConverter {

    @Autowired
    @Qualifier("BookInfConverter")
    BookConverter bookConverter;
    @Autowired
    @Qualifier("NCaseInfConverter")
    NCaseConverter nCaseConverter;
    @Autowired
    @Qualifier("DetailInfConverter")
    DetailConverter detailConverter;

    public InstanceEntity toEntity(Instance instance, Boolean convertBook, Boolean convertNCase) {
        InstanceEntity instanceEntity = InstanceEntity.builder()
                .editor(instance.getEditor())
                .edition(instance.getEdition())
                .inventoryNumber(instance.getInventoryNumber())
                .language(instance.getLanguage())
                .qrCode(instance.getQrCode())
                .publishingDate(instance.getPublishingDate())
                .availability(instance.getAvailability())
                .price(instance.getPrice())
                .detailEntity(detailConverter.toEntity(instance.getDetail()))
                .build();

        if (convertBook)
            instanceEntity.setBookEntity(bookConverter.toEntity(instance.getBook(), false, true));

        if (convertNCase)
            instanceEntity.setNumCaseEntity(nCaseConverter.toEntity(instance.getnCase(), false));

        return instanceEntity;
    }

    public com.mec.libapi.domain.pojo.bookModule.Instance toPojo(InstanceEntity instanceEntity, Boolean convertBook, Boolean convertNCase) {

        com.mec.libapi.domain.pojo.bookModule.Instance instance = new com.mec.libapi.domain.pojo.bookModule.Instance();

        instance.setId(instanceEntity.getId());
        instance.setEditor(instanceEntity.getEditor());
        instance.setEdition(instanceEntity.getEdition());
        instance.setInventoryNumber(instanceEntity.getInventoryNumber());
        instance.setLanguage(instanceEntity.getLanguage());
        instance.setQrCode(instanceEntity.getQrCode());
        instance.setPublishingDate(instanceEntity.getPublishingDate());
        instance.setPrice(instanceEntity.getPrice());
        instance.setDetail(detailConverter.toPojo(instanceEntity.getDetailEntity()));

        if (convertBook)
            instance.setBook(bookConverter.toPojo(instanceEntity.getBookEntity(), false, true));

        if (convertNCase)
            instance.setnCase(nCaseConverter.toPojo(instanceEntity.getNumCaseEntity(), false));

        return instance;
    }

}
