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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {}
    private List<Role> roles;
}