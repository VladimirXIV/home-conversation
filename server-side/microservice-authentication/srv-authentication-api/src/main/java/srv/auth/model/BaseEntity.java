/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import java.util.Date;

/**
 * BaseEntity.
 *
 * @author waldemar
 */
@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountGen")
    @SequenceGenerator(name = "accountGen", schema = "srv_auth", sequenceName = "accounts_seq", allocationSize = 1)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private State state;
}