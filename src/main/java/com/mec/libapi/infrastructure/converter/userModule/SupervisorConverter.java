package com.mec.libapi.infrastructure.converter.userModule;

import com.mec.libapi.domain.pojo.userModule.Fine;
import com.mec.libapi.domain.pojo.userModule.Supervisor;
import com.mec.libapi.infrastructure.entity.userModule.SupervisorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("SupervisorInfConverter")
public class SupervisorConverter {

    @Autowired
    private FineConverter fineConverter;

    public SupervisorEntity to(Supervisor supervisor) {
        return SupervisorEntity.builder()
                .id(supervisor.getId())
                .firstName(supervisor.getFirstName())
                .secondName(supervisor.getSecondName())
                .email(supervisor.getEmail())
                .password(supervisor.getPassword())
                .build();
    }

    public Supervisor toPOJO(SupervisorEntity supervisorEntity) {
        Supervisor supervisor = new Supervisor();
        supervisor.setId(supervisorEntity.getId());
        supervisor.setEmail(supervisorEntity.getEmail());
        supervisor.setPassword(supervisorEntity.getPassword());
        supervisor.setFirstName(supervisorEntity.getFirstName());
        supervisor.setSecondName(supervisorEntity.getSecondName());
        supervisorEntity.getSupervisorFines().forEach(fineEntity -> {
            Fine fine = fineConverter.toPOJO(fineEntity);
            supervisor.getFines().add(fine);
        });
        return supervisor;
    }
}
