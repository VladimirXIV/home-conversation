/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

/**
 * JwtUser.
 *
 * @author waldemar
 */
public class JwtAccountDetails implements UserDetails {

    private final Long id;
    private final String login;
    private final String hashPassword;
    private final Long userId;
    private final Date lastPaswordResetDate;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtAccountDetails(Long id, String login, String hashPassword, Long userId, Date lastPaswordResetDate, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.hashPassword = hashPassword;
        this.userId = userId;
        this.lastPaswordResetDate = lastPaswordResetDate;
        this.enabled = enabled;
        this.authorities = authorities;
    }


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public Date getLastPaswordResetDate() {
        return lastPaswordResetDate;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities ;
    }

    @Override
    public String getPassword() {
        return hashPassword;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}