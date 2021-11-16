package com.mec.libapi.domain.pojo.userModule;

import java.util.List;

public class Supervisor extends User {
    private List<Fine> fines;

    public Supervisor() {
        super();
    }

    public Supervisor(Long id, String firstName, String secondName, String username, String email, String password, String type) {
        super(id, firstName, secondName, username, email, password, type);
    }

    public Supervisor(Long id, String firstName, String secondName, String username, String email, String password, String type, List<Fine> fines) {
        super(id, firstName, secondName, username, email, password, type);
        this.fines = fines;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void setFines(List<Fine> fines) {
        this.fines = fines;
    }
}
