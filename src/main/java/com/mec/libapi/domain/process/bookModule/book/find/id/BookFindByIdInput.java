package com.mec.libapi.domain.process.bookModule.book.find.id;

import com.mec.libapi.domain.process.core.AbstractProcessInput;

public class BookFindByIdInput extends AbstractProcessInput {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
