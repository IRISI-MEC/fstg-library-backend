package com.mec.libapi.domain.pojo.bookModule;

import java.util.List;

public class Speciality {

    private Long id;
    private String label;
    private List<Book> books;

    public Speciality() {
    }

    public Speciality(Long id, String label, List<Book> books) {
        this.id = id;
        this.label = label;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
