package com.mec.libapi.infrastructure.converter.userModule;

import com.mec.libapi.domain.pojo.userModule.Fine;
import com.mec.libapi.domain.pojo.userModule.Professor;
import com.mec.libapi.infrastructure.entity.userModule.FineEntity;
import com.mec.libapi.infrastructure.entity.userModule.ProfessorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("ProfessorInfConverter")
public class ProfessorConverter {

    @Qualifier("FineInfConverter")
    @Autowired
    private FineConverter fineConverter;

    @Qualifier("DepartmentInfConverter")
    @Autowired
    private DepartmentConverter departmentConverter;

    public ProfessorEntity to(Professor professor) {
        List<FineEntity> fineEntities = new ArrayList<>();
        professor.getUserFines().forEach(fine -> fineEntities.add(fineConverter.to(fine)));
        return (ProfessorEntity) ProfessorEntity.builder()
                .department(departmentConverter.to(professor.getDepartment()))
                .id(professor.getId())
                .firstName(professor.getFirstName())
                .secondName(professor.getSecondName())
                .email(professor.getEmail())
                .password(professor.getPassword())
                .overDue(professor.getOverDue())
                .maxBooking(professor.getMaxBooking())
                .userFines(fineEntities)
                .build();
    }

    public Professor toPOJO(ProfessorEntity professorEntity) {
        Professor professor = new Professor();
        professor.setId(professorEntity.getId());
        professor.setFirstName(professor.getFirstName());
        professor.setSecondName(professor.getSecondName());
        professor.setEmail(professor.getEmail());
        professor.setPassword(professor.getPassword());
        professor.setOverDue(professor.getOverDue());
        professor.setMaxBooking(professor.getMaxBooking());

        List<Fine> fines = new ArrayList<>();
        professorEntity.getUserFines().forEach(fineEntity -> fines.add(fineConverter.toPOJO(fineEntity)));
        professor.setUserFines(fines);

        professor.setDepartment(departmentConverter.toPOJO(professorEntity.getDepartment()));
        return professor;
    }
}
