package com.mec.libapi.domain.process.bookModule.book.save;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.converter.bookModule.BookConverter;
import com.mec.libapi.infrastructure.dao.facade.bookModule.BookFacade;
import com.mec.libapi.infrastructure.dao.facade.bookModule.SpecialityFacade;

public class BookSaveProcessImpl extends AbstractProcessImpl<BookSaveInput> implements BookSaveProcess {

    private BookFacade bookFacade;
    private SpecialityFacade specialityFacade;

    public BookSaveProcessImpl(BookFacade bookFacade, SpecialityFacade specialityFacade, BookConverter bookConverter) {
        this.bookFacade = bookFacade;
        this.specialityFacade = specialityFacade;
    }

    @Override
    public void validate(BookSaveInput input, Result result) {
        Speciality speciality = specialityFacade.findById(input.getSpecialityId());
        if (speciality == null) result.addErrorMessage("Speciality does not exist");

        if (input.getIsbn().length() == 10 || input.getIsbn().length() == 13)
            result.addErrorMessage("Invalid Book ISBN");

        Book bookWithSameIsbn = bookFacade.findByIsbn(input.getIsbn());
        if (bookWithSameIsbn != null) result.addErrorMessage("Book with same isbn already exists");
    }

    @Override
    public void run(BookSaveInput input, Result result) {
        Speciality speciality = specialityFacade.findById(input.getSpecialityId());
        result.setOutput(bookFacade.save(new Book(null, input.getIsbn(), input.getTitle(), input.getAuthor(), input.getDescription(), null, speciality)));
        result.addInfoMessage("Book saved successfully");
    }

}
