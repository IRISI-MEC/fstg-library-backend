package com.mec.libapi.domain.process.bookModule.book.find.speciality;

import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.domain.process.core.AbstractProcessInput;

public class BookFindBySpecialityInput extends AbstractProcessInput {

    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
