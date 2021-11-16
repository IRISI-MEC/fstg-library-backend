package com.mec.libapi.domain.pojo.userModule;

import java.util.List;

public class Student extends CanBook {

    private String CNE;
    private Branch branch;

    public Student() {
    }

    public Student(String CNE, Branch branch) {
        this.CNE = CNE;
        this.branch = branch;
    }

    public Student(Long maxBooking, Boolean overDue, List<Fine> userFines, String CNE, Branch branch) {
        super(maxBooking, overDue, userFines);
        this.CNE = CNE;
        this.branch = branch;
    }

    public Student(Long id, String firstName, String secondName, String username, String email, String password, String type, Long maxBooking, Boolean overDue, List<Fine> userFines, String CNE, Branch branch) {
        super(id, firstName, secondName, username, email, password, type, maxBooking, overDue, userFines);
        this.CNE = CNE;
        this.branch = branch;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
