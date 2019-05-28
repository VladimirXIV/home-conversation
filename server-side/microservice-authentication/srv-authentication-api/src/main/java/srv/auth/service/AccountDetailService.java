/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import srv.auth.dao.AccountDao;
import srv.auth.model.Account;

/**
 * CustomUserDetailService.
 *
 * @author waldemar
 */
@Service(value = "accountDetailService")
public class AccountDetailService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(AccountDetailService.class);

    private AccountDao accountDao;

    @Autowired
    public AccountDetailService(@Qualifier(value = "accountDao") AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Account account = accountDao.findByLogin(login);

        if (account == null) {
            log.info("account not found");
            throw new UsernameNotFoundException("Unknown User");
        }
        log.info("load account by login: {}", account);

        User.UserBuilder userBuilder = User.builder();
        userBuilder.username(account.getLogin());
        userBuilder.password(account.getHashPassword());

        return userBuilder.build();
    }
}