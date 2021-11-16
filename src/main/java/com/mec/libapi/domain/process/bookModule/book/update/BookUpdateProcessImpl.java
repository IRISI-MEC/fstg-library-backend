package com.mec.libapi.domain.process.bookModule.book.update;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.bookModule.BookFacade;
import com.mec.libapi.infrastructure.dao.facade.bookModule.SpecialityFacade;

public class BookUpdateProcessImpl extends AbstractProcessImpl<BookUpdateInput> implements BookUpdateProcess {

    private BookFacade bookFacade;
    private SpecialityFacade specialityFacade;

    public BookUpdateProcessImpl(BookFacade bookFacade, SpecialityFacade specialityFacade) {
        this.bookFacade = bookFacade;
        this.specialityFacade = specialityFacade;
    }

    @Override
    public void validate(BookUpdateInput input, Result result) {
        Book bookWithSameId = bookFacade.findById(input.getId());
        if (bookWithSameId == null) result.addErrorMessage("Book does not exist");
        Book bookWithSameIsbn = bookFacade.findByIsbn(input.getIsbn());
        if (bookWithSameIsbn != null) result.addErrorMessage("Book with provided isbn already exist");
        if (input.getTitle() == null)
            result.addErrorMessage("Book title is missing");
        else if (input.getTitle().length() == 0)
            result.addWarningMessage("Title is empty !");

        if (input.getSpecialityId() == null)
            result.addErrorMessage("Book speciality is missing");
        else {
            Speciality speciality = specialityFacade.findById(input.getSpecialityId());
            if (speciality == null) result.addErrorMessage("Speciality does not exist");
        }
    }

    @Override
    public void run(BookUpdateInput input, Result result) {
        Speciality speciality = specialityFacade.findById(input.getSpecialityId());
        result.setOutput(bookFacade.save(new Book(input.getId(), input.getIsbn(), input.getTitle(), input.getAuthor(), input.getDescription(), null, speciality)));
        result.addInfoMessage("Book updated successfully");
    }

}
