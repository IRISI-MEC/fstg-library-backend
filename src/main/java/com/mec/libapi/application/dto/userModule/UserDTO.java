package com.mec.libapi.application.dto.userModule;

import com.mec.libapi.domain.process.userModule.user.login.UserLoginInput;
import com.mec.libapi.domain.process.userModule.user.save.UserSaveInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String type;

    public static UserSaveInput toUserSaveInput(UserDTO userDTO) {
        if (userDTO != null) {
            UserSaveInput userSaveInput = new UserSaveInput(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
            return userSaveInput;
        }
        return null;
    }

    public static UserLoginInput toUserLoginInput(UserDTO userDTO) {
        if (userDTO != null) {
            UserLoginInput userLoginInput = new UserLoginInput(userDTO.getEmail(), userDTO.getPassword());
            return userLoginInput;
        }
        return null;
    }
}
