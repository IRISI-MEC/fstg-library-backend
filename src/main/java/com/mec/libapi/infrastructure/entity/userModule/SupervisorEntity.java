package com.mec.libapi.infrastructure.entity.userModule;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class SupervisorEntity extends UserEntity {
    @OneToMany(mappedBy = "supervisor")
    private List<FineEntity> supervisorFines;

    @Builder
    public SupervisorEntity(Long id, String firstName, String secondName, String username, String email, String password, List<FineEntity> supervisorFines) {
        super(id, firstName, secondName, username, email, password);
        this.supervisorFines = supervisorFines;
    }

    @Builder
    public SupervisorEntity(List<FineEntity> supervisorFines) {
        this.supervisorFines = supervisorFines;
    }

    public static class SupervisorEntityBuilder extends UserEntityBuilder {
        SupervisorEntityBuilder() {
            super();
        }
    }
}
