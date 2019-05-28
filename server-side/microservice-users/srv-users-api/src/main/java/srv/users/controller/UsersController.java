/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import srv.users.dto.UserDtoToUpdate;
import srv.users.service.UserService;

/**
 *
 *
 * @author waldemar
 */

@RestController
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(@Qualifier(value = "userService") UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/addNewUser")
    public void addNewUser(@RequestBody long userId) {
        userService.addNewUser(userId);
    }

    @PostMapping(value = "/updateUser")
    public void updateUser(@RequestBody UserDtoToUpdate userDtoToUpdate) {
        userService.updateUser(userDtoToUpdate.getId(), userDtoToUpdate.getUserInfoDto());
    }
}