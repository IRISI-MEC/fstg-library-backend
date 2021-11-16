package com.mec.libapi.infrastructure.converter.userModule;

import com.mec.libapi.domain.pojo.userModule.Fine;
import com.mec.libapi.infrastructure.entity.userModule.FineEntity;
import org.springframework.stereotype.Component;

@Component("FineInfConverter")
public class FineConverter {

    public FineEntity to(Fine fine) {
        return FineEntity.builder()
                .id(fine.getId())
                .amount(fine.getAmount())
                .date(fine.getDate())
                .reason(fine.getReason())
                .isReturned(fine.getReturned())
                .build();
    }

    public Fine toPOJO(FineEntity fineEntity) {
        Fine fine = new Fine();
        fine.setId(fineEntity.getId());
        fine.setAmount(fineEntity.getAmount());
        fine.setDate(fineEntity.getDate());
        fine.setReason(fineEntity.getReason());
//        supervisor.setFines(supervisorEntity.getSupervisorFines());
        return fine;
    }
}
