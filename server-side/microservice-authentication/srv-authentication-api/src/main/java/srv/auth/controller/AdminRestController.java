/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import srv.auth.dto.AccountDto;
import srv.auth.model.Account;
import srv.auth.service.AccountService;

/**
 * AdminRestController.
 *
 * @author waldemar
 */
@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestController {

    private AccountService accountService;

    @Autowired
    public AdminRestController(@Qualifier(value = "accountService") AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<AccountDto> getAccountById(Long id) {

        Account account = accountService.findById(id);

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AccountDto accountDto = AccountDto.fromAccount(account);

        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PostMapping(value = "user/new")
    @ResponseBody
    public ResponseEntity<AccountDto> createAccount(AccountDto accountDto) {




        return null;
    }

}