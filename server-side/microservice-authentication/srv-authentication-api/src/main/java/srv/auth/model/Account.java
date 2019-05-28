/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import srv.auth.annotation.ValueInc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Account.
 *
 * @author waldemar
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "account", schema = "srv_auth")
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountGen")
    @SequenceGenerator(name = "accountGen", schema = "srv_auth", sequenceName = "accounts_seq", allocationSize = 1)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String hashPassword;

    @Column(name = "user_id")
    @ValueInc(startvalue = 900)
    private Long userId;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private State state = State.ACTIVE;
}