/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.service;

import srv.auth.model.Account;

import java.util.List;

/**
 * AccountService.
 *
 * @author waldemar
 */
public interface AccountService  {

    Account register(Account account);

    List<Account> getAll();

    Account findByLogin(String login);

    Account findById(Long id);

    void delete(Long id);
}