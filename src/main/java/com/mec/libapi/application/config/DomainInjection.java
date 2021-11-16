package com.mec.libapi.application.config;

import com.mec.libapi.domain.process.userModule.user.login.UserLoginProcess;
import com.mec.libapi.domain.process.userModule.user.login.UserLoginProcessImpl;
import com.mec.libapi.domain.process.userModule.user.save.UserSaveProcess;
import com.mec.libapi.domain.process.userModule.user.save.UserSaveProcessImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.UserFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainInjection {

    @Bean
    public UserSaveProcess userSaveProcess(UserFacade userFacade) {
        return new UserSaveProcessImpl(userFacade);
    }

    @Bean
    public UserLoginProcess userLoginProcess(UserFacade userFacade) {
        return new UserLoginProcessImpl(userFacade);
    }
}
