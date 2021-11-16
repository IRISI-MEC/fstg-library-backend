package com.mec.libapi.domain.process.userModule.user.save;

import com.mec.libapi.domain.pojo.userModule.User;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.userModule.UserFacade;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.BeanUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserSaveProcessImpl extends AbstractProcessImpl<UserSaveInput> implements UserSaveProcess {

    private UserFacade userFacade;

    public UserSaveProcessImpl(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    private void validateEmail(String value, Result result) {
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(value)) {
            result.addErrorMessage("Invalid email address");
        }

        User user = userFacade.findByEmail(value);
        if (user == null) {
            result.addErrorMessage("Email Address already used.");
        }
    }

    private void validatePassword(String value, Result result) {
        if (value.length() < 8) {
            result.addErrorMessage("Le mot de passe doit contenir au moins 8 caractères.");
        }
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(value);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (!isStringContainsSpecialCharacter) {
            result.addErrorMessage("Le mot de passe doit contenir au moins un caractère special.");
        }
    }

    @Override
    public void validate(UserSaveInput input, Result result) {
        validateEmail(input.getEmail(), result);
        validatePassword(input.getPassword(), result);
    }

    @Override
    public void run(UserSaveInput input, Result result) {
        User user = new User();
        BeanUtils.copyProperties(input, user);
        userFacade.save(user);
        result.addInfoMessage("Votre compte a été créer avec Succés");
    }
}
