package com.mec.libapi.domain.process.bookModule.book.delete;

import com.mec.libapi.domain.process.core.AbstractProcessInput;

public class BookDeleteByIdInput extends AbstractProcessInput {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
