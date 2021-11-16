package com.mec.libapi.infrastructure.entity.userModule;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class ProfessorEntity extends CanBookEntity {
    @ManyToOne
    private DepartmentEntity department;

    @Builder
    public ProfessorEntity(DepartmentEntity department) {
        this.department = department;
    }

    @Builder
    public ProfessorEntity(Long id, String firstName, String secondName, String username, String email, String password, Long maxBooking, Boolean overDue, List<FineEntity> userFines, DepartmentEntity department) {
        super(id, firstName, secondName, username, email, password, maxBooking, overDue, userFines);
        this.department = department;
    }

    @Builder
    public ProfessorEntity(Long maxBooking, Boolean overDue, List<FineEntity> userFines, DepartmentEntity department) {
        super(maxBooking, overDue, userFines);
        this.department = department;
    }

    public static class ProfessorEntityBuilder extends CanBookEntityBuilder {
        ProfessorEntityBuilder() {
            super();
        }
    }
}
