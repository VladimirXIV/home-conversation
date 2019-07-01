/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import srv.auth.model.Account;
import srv.auth.service.AccountService;

/**
 * JwtAccountDetailsService.
 *
 * @author waldemar
 */
@Slf4j
public class JwtAccountDetailsService implements UserDetailsService {

    private final AccountService accountService;

    public JwtAccountDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Account account = accountService.findByLogin(login);

        if (account == null) {
            throw new UsernameNotFoundException("Account with login: " + login + "not found");
        }

        JwtAccount jwtAccount = JwtAccountFactory.create(account);
        log.info("IN loadUserByUsername - account with name: {} successfully loaded", login);

        return jwtAccount;
    }
}