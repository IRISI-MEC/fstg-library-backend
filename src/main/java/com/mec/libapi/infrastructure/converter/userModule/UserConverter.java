package com.mec.libapi.infrastructure.converter.userModule;

import com.mec.libapi.domain.pojo.userModule.User;
import com.mec.libapi.infrastructure.entity.userModule.UserEntity;
import org.springframework.stereotype.Component;

@Component("UserInfConverter")
public class UserConverter {

    public UserEntity to(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public User toPOJO(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setSecondName(userEntity.getSecondName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        return user;
    }
}
