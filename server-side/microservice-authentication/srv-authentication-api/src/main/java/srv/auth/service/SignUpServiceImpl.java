/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import srv.auth.dao.AccountDao;
import srv.auth.dto.AccountDto;


/**
 * SignUpServiceImpl.
 *
 * @author waldemar
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    private PasswordEncoder passwordEncoder;

    private AccountDao accountDao;


    @Autowired
    public SignUpServiceImpl(PasswordEncoder passwordEncoder, AccountDao accountDao) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(AccountDto accountForm) {
        String hashPassword = passwordEncoder.encode(accountForm.getPassword());

    }

}