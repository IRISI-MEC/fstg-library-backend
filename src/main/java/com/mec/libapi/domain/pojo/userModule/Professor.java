package com.mec.libapi.domain.pojo.userModule;

import java.util.List;

public class Professor extends CanBook {
    private Department department;

    public Professor() {
    }

    public Professor(Department department) {
        this.department = department;
    }

    public Professor(Long maxBooking, Boolean overDue, List<Fine> userFines, Department department) {
        super(maxBooking, overDue, userFines);
        this.department = department;
    }

    public Professor(Long id, String firstName, String secondName, String username, String email, String password, String type, Long maxBooking, Boolean overDue, List<Fine> userFines, Department department) {
        super(id, firstName, secondName, username, email, password, type, maxBooking, overDue, userFines);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
