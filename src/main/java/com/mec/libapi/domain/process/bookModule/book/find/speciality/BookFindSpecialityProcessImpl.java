package com.mec.libapi.domain.process.bookModule.book.find.speciality;

import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.bookModule.BookFacade;
import com.mec.libapi.infrastructure.dao.facade.bookModule.SpecialityFacade;

public class BookFindSpecialityProcessImpl extends AbstractProcessImpl<BookFindBySpecialityInput> implements BookFindBySpecialityProcess {

    private BookFacade bookFacade;
    private SpecialityFacade specialityFacade;

    public BookFindSpecialityProcessImpl(BookFacade bookFacade, SpecialityFacade specialityFacade) {
        this.bookFacade = bookFacade;
        this.specialityFacade = specialityFacade;
    }

    @Override
    public void validate(BookFindBySpecialityInput input, Result result) {
        Speciality speciality = specialityFacade.findById(input.getSpeciality().getId());
        if (speciality == null) result.addErrorMessage("Speciality does not exist");
    }

    @Override
    public void run(BookFindBySpecialityInput input, Result result) {
        Speciality speciality = input.getSpeciality();
        result.setOutput(bookFacade.findBySpeciality(speciality));
    }

}
