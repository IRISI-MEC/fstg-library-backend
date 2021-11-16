package com.mec.libapi.infrastructure.converter.bookModule;

import com.mec.libapi.domain.pojo.bookModule.NCase;
import com.mec.libapi.infrastructure.entity.bookModule.NCaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("NCaseInfConverter")
public class NCaseConverter {

    @Autowired
    @Qualifier("InstanceInfConverter")
    InstanceConverter instanceConverter;

    public NCaseEntity toEntity(NCase nCase, Boolean convertInstances) {
        NCaseEntity nCaseEntity = NCaseEntity.builder()
                .id(nCase.getId())
                .code(nCase.getCode())
                .build();

        if (convertInstances)
            nCase.getInstances().forEach(instance -> nCaseEntity.getInstanceEntities().add(instanceConverter.toEntity(instance, true, false)));

        return nCaseEntity;
    }

    public NCase toPojo(NCaseEntity nCaseEntity, Boolean convertInstances) {
        NCase nCase = new NCase();
        nCase.setId(nCaseEntity.getId());
        nCase.setCode(nCaseEntity.getCode());
        if (convertInstances)
            nCaseEntity.getInstanceEntities().forEach(instanceEntity -> nCase.getInstances().add(instanceConverter.toPojo(instanceEntity, true, false)));

        return nCase;
    }

}
