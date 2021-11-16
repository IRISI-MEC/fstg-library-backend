package com.mec.libapi.application.rest.userModule;

import com.mec.libapi.application.dto.userModule.UserDTO;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.domain.process.userModule.user.login.UserLoginInput;
import com.mec.libapi.domain.process.userModule.user.login.UserLoginProcess;
import com.mec.libapi.domain.process.userModule.user.save.UserSaveInput;
import com.mec.libapi.domain.process.userModule.user.save.UserSaveProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/user")
public class UserRest {

    @Autowired
    private UserSaveProcess userSaveProcess;
    @Autowired
    private UserLoginProcess userLoginProcess;

    @PostMapping("/")
    public Result save(@RequestBody UserDTO userDTO) {
        UserSaveInput userSaveInput = userDTO.toUserSaveInput(userDTO);
        return userSaveProcess.execute(userSaveInput);
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        UserLoginInput userLoginInput = userDTO.toUserLoginInput(userDTO);
        return userLoginProcess.execute(userLoginInput);
    }
}
