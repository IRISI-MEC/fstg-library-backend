package com.mec.libapi.domain.process.bookModule.book.find.id;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.bookModule.BookFacade;

public class BookFindByIdProcessImpl extends AbstractProcessImpl<BookFindByIdInput> implements BookFindByIdProcess {

    private BookFacade bookFacade;

    public BookFindByIdProcessImpl(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @Override
    public void validate(BookFindByIdInput input, Result result) {
        Book book = bookFacade.findById(input.getId());
        if (book == null) result.addErrorMessage("Book not found with id: " + input.getId());
    }

    @Override
    public void run(BookFindByIdInput input, Result result) {
        result.setOutput(bookFacade.findById(input.getId()));
        result.addInfoMessage("Book found");
    }

}
