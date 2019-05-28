/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.service;

import org.springframework.stereotype.Service;
import srv.auth.model.Account;

/**
 * AccountService.
 *
 * @author waldemar
 */
public interface AccountService {

    Account createNewAccount(Account account);

}