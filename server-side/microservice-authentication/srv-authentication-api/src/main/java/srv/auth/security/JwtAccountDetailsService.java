/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import srv.auth.model.Account;
import srv.auth.service.AccountService;

/**
 * JwtAccountDetailsService.
 *
 * @author waldemar
 */
@Slf4j
@Component(value = "jwtAccountDetailsService")
public class JwtAccountDetailsService implements UserDetailsService {

    private final AccountService accountService;

    @Autowired
    public JwtAccountDetailsService(@Qualifier(value = "accountService") AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Account account = accountService.findByLogin(login);

        if (account == null) {
            throw new UsernameNotFoundException("Account with login: " + login + "not found");
        }

        JwtAccountDetails jwtAccount = JwtAccountFactory.create(account);
        log.info("IN loadUserByUsername - account with name: {} successfully loaded", login);

        return jwtAccount;
    }
}