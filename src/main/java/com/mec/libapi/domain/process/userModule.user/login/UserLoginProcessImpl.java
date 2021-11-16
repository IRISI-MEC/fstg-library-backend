package com.mec.libapi.domain.process.userModule.user.login;

import com.mec.libapi.domain.pojo.userModule.User;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.userModule.UserFacade;
import org.apache.commons.validator.routines.EmailValidator;

public class UserLoginProcessImpl extends AbstractProcessImpl<UserLoginInput> implements UserLoginProcess {

    private UserFacade userFacade;

    public UserLoginProcessImpl(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    private void validateEmail(String value, Result result) {
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(value)) {
            result.addErrorMessage("Invalid email address");
        }
    }

    @Override
    public void validate(UserLoginInput input, Result result) {
        validateEmail(input.getEmail(), result);
    }

    @Override
    public void run(UserLoginInput input, Result result) {
        String email = input.getEmail();
        String password = input.getPassword();
        User user = userFacade.findByEmailAndPassword(email, password);
        if (user != null) {
            result.addErrorMessage("User was found.");
            result.setOutput(user);
            result.setStatus(1);
        }
    }
}
