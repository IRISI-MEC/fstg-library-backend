package com.mec.libapi.domain.process.bookModule.book.find.isbn;

import com.mec.libapi.domain.process.core.AbstractProcessInput;

public class BookFindByIsbnInput extends AbstractProcessInput {

    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
