package com.mec.libapi.infrastructure.entity.userModule;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@Data
@Inheritance
@Entity
public class CanBookEntity extends UserEntity {
    private Long maxBooking;
    private Boolean overDue;
    @OneToMany(mappedBy = "canBook")
    private List<FineEntity> userFines;

    @Builder
    public CanBookEntity(Long id, String firstName, String secondName, String username, String email, String password, Long maxBooking, Boolean overDue, List<FineEntity> userFines) {
        super(id, firstName, secondName, username, email, password);
        this.maxBooking = maxBooking;
        this.overDue = overDue;
        this.userFines = userFines;
    }

    @Builder
    public CanBookEntity(Long maxBooking, Boolean overDue, List<FineEntity> userFines) {
        this.maxBooking = maxBooking;
        this.overDue = overDue;
        this.userFines = userFines;
    }

    public static class CanBookEntityBuilder extends UserEntityBuilder {
        CanBookEntityBuilder() {
            super();
        }
    }

    // STOPSHIP
}
