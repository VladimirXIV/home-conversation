/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import srv.auth.annotation.ValueInc;

import javax.persistence.*;
import java.util.List;

/**
 * Account.
 *
 * @author waldemar
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "account", schema = "srv_auth")
public class Account extends BaseEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String hashPassword;

    @Column(name = "id")
    @ValueInc(startvalue = 900)
    private Long userId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_roles", schema = "srv_auth",
               joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")},
               inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}