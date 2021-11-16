package com.mec.libapi.domain.pojo.userModule;

import com.mec.libapi.infrastructure.entity.userModule.CanBookEntity;
import com.mec.libapi.infrastructure.entity.userModule.SupervisorEntity;

import java.time.LocalDate;

public class Fine {

    private Long id;
    private Double amount;
    private String reason;
    private LocalDate date;
    private Boolean isReturned;
    private SupervisorEntity supervisor;
    private CanBookEntity canBook;

    public Fine() {
    }

    public Fine(Long id, Double amount, String reason, LocalDate date, Boolean isReturned, SupervisorEntity supervisor, CanBookEntity canBook) {
        this.id = id;
        this.amount = amount;
        this.reason = reason;
        this.date = date;
        this.isReturned = isReturned;
        this.supervisor = supervisor;
        this.canBook = canBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getReturned() {
        return isReturned;
    }

    public void setReturned(Boolean returned) {
        isReturned = returned;
    }

    public SupervisorEntity getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(SupervisorEntity supervisor) {
        this.supervisor = supervisor;
    }

    public CanBookEntity getCanBook() {
        return canBook;
    }

    public void setCanBook(CanBookEntity canBook) {
        this.canBook = canBook;
    }
}
