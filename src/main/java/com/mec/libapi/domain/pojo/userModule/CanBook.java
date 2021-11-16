package com.mec.libapi.domain.pojo.userModule;

import java.util.List;

public class CanBook extends User {
    private Long maxBooking;
    private Boolean overDue;
    private List<Fine> userFines;

    public CanBook() {
    }

    public CanBook(Long maxBooking, Boolean overDue, List<Fine> userFines) {
        this.maxBooking = maxBooking;
        this.overDue = overDue;
        this.userFines = userFines;
    }

    public CanBook(Long id, String firstName, String secondName, String username, String email, String password, String type, Long maxBooking, Boolean overDue, List<Fine> userFines) {
        super(id, firstName, secondName, username, email, password, type);
        this.maxBooking = maxBooking;
        this.overDue = overDue;
        this.userFines = userFines;
    }

    public Long getMaxBooking() {
        return maxBooking;
    }

    public void setMaxBooking(Long maxBooking) {
        this.maxBooking = maxBooking;
    }

    public Boolean getOverDue() {
        return overDue;
    }

    public void setOverDue(Boolean overDue) {
        this.overDue = overDue;
    }

    public List<Fine> getUserFines() {
        return userFines;
    }

    public void setUserFines(List<Fine> userFines) {
        this.userFines = userFines;
    }
}
