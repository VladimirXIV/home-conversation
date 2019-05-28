/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.service;

import org.springframework.stereotype.Service;
import srv.auth.dto.AccountDto;

/**
 * SignUpService.
 *
 * @author waldemar
 */
@Service
public interface SignUpService {

    public void signUp(AccountDto accountForm);

}