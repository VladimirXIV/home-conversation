/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.users.service;


import srv.users.dto.UserInfoDto;

/**
 * UserService.
 *
 * @author waldemar
 */
public interface UserService {

    void addNewUser(Long userId);

    void updateUser(Long userId, UserInfoDto userDtoInfo);
}