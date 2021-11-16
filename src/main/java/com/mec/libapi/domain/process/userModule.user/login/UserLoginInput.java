package com.mec.libapi.domain.process.userModule.user.login;

import com.mec.libapi.domain.process.core.AbstractProcessInput;

public class UserLoginInput extends AbstractProcessInput {
    private String email;
    private String password;

    public UserLoginInput() {
    }

    public UserLoginInput(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
