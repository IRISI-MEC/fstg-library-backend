package com.mec.libapi.infrastructure.dao.facade.bookModule;

import com.mec.libapi.domain.pojo.bookModule.NCase;
import com.mec.libapi.infrastructure.dao.facade.AbstractFacade;

public interface NCaseFacade extends AbstractFacade<NCase, Long> {

    NCase findByCode(String code);

}
