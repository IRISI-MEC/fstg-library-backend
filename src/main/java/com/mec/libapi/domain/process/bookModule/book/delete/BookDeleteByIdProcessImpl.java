package com.mec.libapi.domain.process.bookModule.book.delete;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.bookModule.BookFacade;

public class BookDeleteByIdProcessImpl extends AbstractProcessImpl<BookDeleteByIdInput> implements BookDeleteByIdProcess {

    private BookFacade bookFacade;

    public BookDeleteByIdProcessImpl(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @Override
    public void validate(BookDeleteByIdInput input, Result result) {
        Book book = bookFacade.findById(input.getId());
        if (book == null) result.addErrorMessage("Book not found with id: " + input.getId());
    }

    @Override
    public void run(BookDeleteByIdInput input, Result result) {
        bookFacade.delete(input.getId());
        result.addInfoMessage("Book deleted successfully");
    }
}
