package srv.auth.service.impl;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import srv.auth.exception.AccountNotFoundException;
import srv.auth.model.Account;
import srv.auth.model.Role;
import srv.auth.repository.AccountRepository;

import java.util.Objects;

/**
 * @author vladimir.fedotov
 * @since 28-Jan-20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String login) {

        Account account = accountRepository.findByLogin(login);
        if (Objects.isNull(account)) {
            throw new AccountNotFoundException("Account not found by login: " + login);
        }

        return toUserDetails(account);
    }

    private UserDetails toUserDetails(Account account) {

        return User.withUsername(account.getLogin())
                .password(account.getHashPassword())
                .roles(String.valueOf(account.getRoles().stream().map(Role::getName)))
                .build();
    }
}