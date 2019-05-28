/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * DeletedMessage.
 *
 * @author waldemar
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "deleted_message", schema = "srv_message")
public class DeletedMessage {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageGen")
    @SequenceGenerator(name = "messageGen", schema = "srv_message", sequenceName = "message_seq")
    private Long id;

    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "participant_id")
    private Long participantId;

    @Column(name = "deleted_at")
    private Date deletedAt;
}