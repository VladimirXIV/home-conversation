/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.dto;

import lombok.Data;

/**
 * acoountDto.
 *
 * @author waldemar
 */
@Data
public class AuthenticationAccountDto {
    private String password;
    private String name;
}