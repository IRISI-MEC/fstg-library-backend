package com.mec.libapi.domain.process.bookModule.book.find.isbn;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.bookModule.BookFacade;

public class BookFindByIsbnProcessImpl extends AbstractProcessImpl<BookFindByIsbnInput> implements BookFindByIsbnProcess {

    private BookFacade bookFacade;

    public BookFindByIsbnProcessImpl(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @Override
    public void validate(BookFindByIsbnInput input, Result result) {
        Book book = bookFacade.findByIsbn(input.getIsbn());
        if (book == null) result.addErrorMessage("Book not found with isbn :" + input.getIsbn());
    }

    @Override
    public void run(BookFindByIsbnInput input, Result result) {
        result.setOutput(bookFacade.findByIsbn(input.getIsbn()));
        result.addInfoMessage("Book found");
    }
}
