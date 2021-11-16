package com.mec.libapi.domain.process.userModule.user.save;

import com.mec.libapi.domain.process.core.AbstractProcessInput;

public class UserSaveInput extends AbstractProcessInput {
    private String username;
    private String email;
    private String password;

    public UserSaveInput() {
    }
    public UserSaveInput(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
