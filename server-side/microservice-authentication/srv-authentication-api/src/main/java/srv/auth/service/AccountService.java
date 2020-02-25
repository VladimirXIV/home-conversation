package srv.auth.service;

import srv.auth.model.Account;

/**
 * @author vladimir.fedotov
 * @since 28-Jan-20
 */
public interface AccountService {

    public void save(Account account);

    public Account findById(Long id);
}
