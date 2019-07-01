/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import srv.auth.dto.AuthenticationAccountDto;
import srv.auth.model.Account;
import srv.auth.security.jwt.JwtTokenProvider;
import srv.auth.service.AccountService;

import java.util.HashMap;
import java.util.Map;

/**
 * SignUp.
 *
 * @author waldemar
 */

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private final AccountService accountService;

    @Autowired
    public AuthenticationController(@Qualifier(value = "accountService") AccountService accountService,
                                    @Qualifier(value = "jwtTokenProvider") JwtTokenProvider jwtTokenProvider,
                                    @Qualifier(value = "authenticationManager") AuthenticationManager authenticationManager) {
        this.accountService = accountService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

   public ResponseEntity login(@RequestBody AuthenticationAccountDto requestAccountDto) {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestAccountDto.getName(), requestAccountDto.getPassword()));

            Account account = accountService.findByLogin(requestAccountDto.getName());

            if (account == null) {
                throw new UsernameNotFoundException("Account with username: " + requestAccountDto.getName() + " not found");
            }

            String token = jwtTokenProvider.createToken(requestAccountDto.getName(), account.getRoles());

            Map<Object, Object>  response = new HashMap<>();
            response.put("username", requestAccountDto.getName());
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid usermane or password");
        }

   }
}