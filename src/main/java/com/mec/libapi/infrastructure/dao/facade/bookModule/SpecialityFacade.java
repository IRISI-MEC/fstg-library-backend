package com.mec.libapi.infrastructure.dao.facade.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Speciality;
import com.mec.libapi.infrastructure.dao.facade.AbstractFacade;

public interface SpecialityFacade extends AbstractFacade<Speciality, Long> {

    Speciality findByLabel(String label);

}
