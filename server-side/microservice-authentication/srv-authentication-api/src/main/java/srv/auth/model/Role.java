/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Role.
 *
 * @author waldemar
 */
@Entity
@Table(name = "roles", schema = "srv_auth")
@Data
public class Role extends BaseEntity {


    @Column(name = "name")
    private String name;

}