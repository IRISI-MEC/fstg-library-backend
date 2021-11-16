package com.mec.libapi.infrastructure.dao.impl.userModule;

import com.mec.libapi.domain.pojo.userModule.User;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.UserFacade;
import com.mec.libapi.infrastructure.dao.repository.userModule.UserRepository;
import com.mec.libapi.infrastructure.entity.userModule.ProfessorEntity;
import com.mec.libapi.infrastructure.entity.userModule.StudentEntity;
import com.mec.libapi.infrastructure.entity.userModule.SupervisorEntity;
import com.mec.libapi.infrastructure.entity.userModule.UserEntity;
import com.mec.libapi.util.HashUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserFacadeImpl extends AbstractFacadeImpl implements UserFacade {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity;
        if (user != null) {
            switch (user.getType()) {
                case "student":
                    userEntity = new StudentEntity();
                    break;
                case "professor":
                    userEntity = new ProfessorEntity();
                    break;
                case "supervisor":
                    userEntity = new SupervisorEntity();
                    break;
                default:
                    userEntity = new UserEntity();
            }
            BeanUtils.copyProperties(user, userEntity);
            String hashedPassword = HashUtil.encryptPassword(userEntity.getPassword());
            userEntity.setPassword(hashedPassword);
            userRepository.save(userEntity);
        }
        return null;
    }

    @Override
    public User findById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            User user = new User();
            BeanUtils.copyProperties(userEntity.get(), user);
            return user;
        }
        return null;
    }

    @Override
    public Stream<User> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            users.add(user);
        });
        return users.stream();
    }

    @Override
    public void delete(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        userEntity.ifPresent(entity -> userRepository.delete(entity));
    }

    @Override
    public User findByEmail(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            User user = new User();
            BeanUtils.copyProperties(userEntity.get(), user);
            return user;
        }
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        String hashedPassword = HashUtil.encryptPassword(password);
        Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(email, hashedPassword);
        if (userEntity.isPresent()) {
            User user = new User();
            BeanUtils.copyProperties(userEntity.get(), user);
            return user;
        }
        return null;
    }
}
