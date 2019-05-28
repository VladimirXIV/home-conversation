/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.users.dto;

import lombok.Data;

import java.util.Date;

/**
 * UserDto.
 *
 * @author waldemar
 */
@Data
public class UserInfoDto {
    private String phone;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private boolean isActive;
    private boolean isReported;
    private boolean isBlocked;
    private Date createdAt;
    private Date updatedAt;
    private String verificationCode;

}