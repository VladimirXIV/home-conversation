/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import srv.auth.model.Account;

/**
 * AccountRepository.
 *
 * @author waldemar
 */
@Repository(value = "accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByLogin(String login);
}