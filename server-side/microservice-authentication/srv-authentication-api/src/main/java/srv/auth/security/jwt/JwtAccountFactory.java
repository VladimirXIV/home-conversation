/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import srv.auth.model.Account;
import srv.auth.model.Role;
import srv.auth.model.State;

import java.util.List;
import java.util.stream.Collectors;

/**
 * JwtUserFactory.
 *
 * @author waldemar
 */
public final class JwtAccountFactory {

    public JwtAccountFactory() {

    }

    public static JwtAccount create(Account account) {
        return new JwtAccount(account.getId(),
                account.getLogin(),
                account.getHashPassword(),
                account.getUserId(),
                account.getUpdated(),
                account.getState().equals(State.ACTIVE),
                null);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}