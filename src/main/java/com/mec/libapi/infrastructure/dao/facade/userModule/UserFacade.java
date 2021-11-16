package com.mec.libapi.infrastructure.dao.facade.userModule;

import com.mec.libapi.domain.pojo.userModule.User;
import com.mec.libapi.infrastructure.dao.core.AbstractFacade;

public interface UserFacade extends AbstractFacade<User, Long> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
