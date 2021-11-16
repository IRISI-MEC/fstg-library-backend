package com.mec.libapi.domain.pojo.bookModule;

import com.mec.libapi.util.Availability;

import java.time.LocalDate;

public class Instance {

    private Long id;
    private String qrCode;
    private Long inventoryNumber;
    private String editor;
    private String edition;
    private LocalDate publishingDate;
    private String language;
    private Double price;
    private Availability availability;
    private Book book;
    private NCase nCase;
    private Detail detail;

    public Instance() {
    }

    public Instance(Long id, String qrCode, Long inventoryNumber, String editor, String edition, LocalDate publishingDate, String language, Double price, Availability availability, Book book, NCase nCase, Detail detail) {
        this.id = id;
        this.qrCode = qrCode;
        this.inventoryNumber = inventoryNumber;
        this.editor = editor;
        this.edition = edition;
        this.publishingDate = publishingDate;
        this.language = language;
        this.price = price;
        this.availability = availability;
        this.book = book;
        this.nCase = nCase;
        this.detail = detail;
    }

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

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
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

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public NCase getnCase() {
        return nCase;
    }

    public void setnCase(NCase nCase) {
        this.nCase = nCase;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
