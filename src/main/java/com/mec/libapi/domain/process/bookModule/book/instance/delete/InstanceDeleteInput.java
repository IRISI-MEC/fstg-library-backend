package com.mec.libapi.domain.process.bookModule.book.instance.delete;

import com.mec.libapi.domain.process.core.AbstractProcessInput;

public class InstanceDeleteInput extends AbstractProcessInput {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
