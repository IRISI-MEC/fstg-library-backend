package com.mec.libapi.infrastructure.dao.facade.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Detail;
import com.mec.libapi.infrastructure.dao.core.AbstractFacade;

public interface DetailFacade extends AbstractFacade<Detail, Long> {

    Detail findByAllAttributes(String butType, String condition, String dSlip, String provider);

}
