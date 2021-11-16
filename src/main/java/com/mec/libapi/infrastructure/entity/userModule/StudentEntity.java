package com.mec.libapi.infrastructure.entity.userModule;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class StudentEntity extends CanBookEntity {
    @Column(unique = true)
    private String CNE;
    @ManyToOne
    private BranchEntity branch;

    @Builder
    public StudentEntity(String CNE, BranchEntity branch) {
        this.CNE = CNE;
        this.branch = branch;
    }

    @Builder
    public StudentEntity(Long id, String firstName, String secondName, String username, String email, String password, Long maxBooking, Boolean overDue, List<FineEntity> userFines, String CNE, BranchEntity branch) {
        super(id, firstName, secondName, username, email, password, maxBooking, overDue, userFines);
        this.CNE = CNE;
        this.branch = branch;
    }

    @Builder
    public StudentEntity(Long maxBooking, Boolean overDue, List<FineEntity> userFines, String CNE, BranchEntity branch) {
        super(maxBooking, overDue, userFines);
        this.CNE = CNE;
        this.branch = branch;
    }

    public static class StudentEntityBuilder extends CanBookEntityBuilder {
        StudentEntityBuilder() {
            super();
        }
    }
}
