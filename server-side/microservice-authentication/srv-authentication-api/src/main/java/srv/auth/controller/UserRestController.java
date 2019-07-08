/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import srv.auth.service.AccountService;

/**
 * UserRestController.
 *
 * @author waldemar
 */
@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserRestController {

    private AccountService accountService;

    @Autowired
    public UserRestController(@Qualifier(value = "accountService") AccountService accountService) {
        this.accountService = accountService;
    }


}

