package com.mec.libapi.application.converter.BookModule;

import com.mec.libapi.application.dto.bookModule.NCaseDto;
import com.mec.libapi.domain.pojo.bookModule.NCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("NCaseAppConverter")
public class NCaseConverter {

    @Autowired
    @Qualifier("InstanceAppConverter")
    InstanceConverter instanceConverter;

    NCase toPojo(NCaseDto nCaseDto) {
        NCase nCase = new NCase();
        nCase.setId(Long.parseLong(nCaseDto.getId()));
        nCase.setCode(nCaseDto.getCode());
        return nCase;
    }

    NCaseDto toDto(NCase nCase, Boolean convertBooks) {

        NCaseDto nCaseDto = NCaseDto.builder()
                .id(nCase.getId().toString())
                .code(nCase.getCode())
                .build();

        if (convertBooks)
            nCase.getInstances().forEach(instance -> nCaseDto.getBooks().add(instanceConverter.toDto(instance, false, true)));

        return nCaseDto;
    }


}
