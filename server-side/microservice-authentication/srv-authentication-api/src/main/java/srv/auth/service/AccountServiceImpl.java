/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import srv.auth.model.Account;
import srv.auth.model.Role;
import srv.auth.model.State;
import srv.auth.repository.AccountRepository;
import srv.auth.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * AccountServiceImpl.
 *
 * @author waldemar
 */
@Slf4j
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account register(Account account) {
        Role roleAccount = roleRepository.findByName("ROLE_ACCOUNT");
        List<Role> accountRoles = new ArrayList<>();
        accountRoles.add(roleAccount);

        account.setHashPassword(passwordEncoder.encode(account.getHashPassword()));
        account.setRoles(accountRoles);
        account.setState(State.ACTIVE);

        Account registeredAccount = accountRepository.save(account);
        log.info("IN register - account: {} successfully registered", registeredAccount);

        return registeredAccount;
    }

    @Override
    public List<Account> getAll() {
        List<Account> result = accountRepository.findAll();
        log.info("IN getAll - {} accounts found", result.size());
        return result;
    }

    @Override
    public Account findByLogin(String login) {
        Account account = accountRepository.findByLogin(login);
        log.info("IN findByLogin - account: {} find by login: {}", account, login);
        return account;
    }

    @Override
    public Account findById(Long id) {
        Account result = accountRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN fingById - account: {} found by id: {}", result);
        return result;
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }
}