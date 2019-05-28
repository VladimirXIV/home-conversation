/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.users.dto;

import lombok.Data;

/**
 * UserDtoToUpdate.
 *
 * @author waldemar
 */
@Data
public class UserDtoToUpdate {
    private Long id;
    private UserInfoDto userInfoDto;
}