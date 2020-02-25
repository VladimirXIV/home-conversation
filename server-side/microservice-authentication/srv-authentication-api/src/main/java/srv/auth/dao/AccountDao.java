package srv.auth.dao;

import srv.auth.model.Account;

public interface AccountDao extends GenericDao<Account> {

    public Account findByLogin(String login);

    public Account findById(Long id);
}
