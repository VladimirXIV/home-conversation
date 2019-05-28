/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import srv.auth.dao.AccountDao;
import srv.auth.model.Account;

/**
 * AccountService.
 *
 * @author waldemar
 */
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(@Qualifier(value = "accountDao") AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account createNewAccount(Account account) {
        return accountDao.create(account);
    }


}