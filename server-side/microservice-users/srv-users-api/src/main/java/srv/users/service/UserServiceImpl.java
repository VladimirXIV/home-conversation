/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import srv.users.dto.UserInfoDto;
import srv.users.model.User;
import srv.users.repository.UserRepository;

/**
 * UserServiceImpl.
 *
 * @author waldemar
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(@Qualifier(value = "userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addNewUser(Long userId) {

        User user = new User();
        user.setId(userId);

        userRepository.save(user);
    }

    @Override
    public void updateUser(Long userId, UserInfoDto userInfoDto) {

        User user = userRepository.getOne(userId);

        user.setActive(userInfoDto.isActive());
        user.setBlocked(userInfoDto.isBlocked());
        user.setCreatedAt(userInfoDto.getCreatedAt());
        user.setEmail(userInfoDto.getEmail());
        user.setFirstName(userInfoDto.getFirstName());
        user.setLastName(userInfoDto.getLastName());
        user.setMiddleName(userInfoDto.getMiddleName());
        user.setPhone(userInfoDto.getPhone());
        user.setReported(userInfoDto.isReported());
        user.setUpdatedAt(userInfoDto.getUpdatedAt());

        userRepository.save(user);
    }
}