package com.mec.libapi.domain.process.bookModule.book.instance.add;

import com.mec.libapi.domain.pojo.bookModule.Detail;
import com.mec.libapi.domain.process.core.AbstractProcessInput;

public class InstanceAddInput extends AbstractProcessInput {

    private Long id;
    private String qrCode;
    private Long inventoryNumber;
    private String editor;
    private String edition;
    private String publishingDate;
    private String language;
    private Double price;
    private Integer availability;

    private Long bookId;
    private Long nCaseId;
    private Detail detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Long getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Long inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getnCaseId() {
        return nCaseId;
    }

    public void setnCaseId(Long nCaseId) {
        this.nCaseId = nCaseId;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
