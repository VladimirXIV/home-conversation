/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import srv.auth.dto.AccountDto;
import srv.auth.model.Account;
import srv.auth.service.AccountService;

/**
 * SignUp.
 *
 * @author waldemar
 */

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private AccountService accountService;

    private KafkaTemplate<String, Long> kafkaTemplate;

    private static final String TOPIC = "hellokafka";

    @Autowired
    public AuthenticationController(@Qualifier(value = "accountService") AccountService accountService,
                                    @Qualifier(value = "kafkaTemplate") KafkaTemplate<String, Long> kafkaTemplate) {
        this.accountService = accountService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(value = "/signIn")
    public String signIn(@RequestBody AccountDto accountDto) {
        return "login: " + accountDto.getName() + " password: " + accountDto.getPassword();
    }

    @PostMapping(value = "/signUp")
    public Long signUp(@RequestBody AccountDto accountDto) {

        long id = accountService.createNewAccount(new Account(accountDto.getName(), accountDto.getPassword())).getId();

        kafkaTemplate.send(TOPIC, id);

        return id;
    }
}