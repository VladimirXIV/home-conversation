package srv.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import srv.auth.dao.AccountDao;
import srv.auth.model.Account;
import srv.auth.service.AccountService;

/**
 * @author vladimir.fedotov
 * @since 28-Jan-20
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public void save(Account account) {

        Account duplicateAccount = accountDao.findByLogin(account.getLogin());
        if (duplicateAccount != null && duplicateAccount.getId() != account.getId()) {
            throw new RuntimeException("Duplicate username.");
        }

        accountDao.create(account);
    }

    @Override
    public Account findById(Long id) {

        return accountDao.findById(id);

    }

}
