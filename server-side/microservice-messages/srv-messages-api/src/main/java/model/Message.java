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
 * Message.
 *
 * @author waldemar
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "message", schema = "srv_message")
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageGen")
    @SequenceGenerator(name = "messageGen", schema = "srv_message", sequenceName = "message_seq")
    private Long id;

    @Column(name = "conversation_id")
    private Long conversationId;

    @Column(name = "participant_id")
    private Long participantId;

    @Column(name = "message")
    private String message;

    @Column(name = "message_type")
    private String messageType;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted_at")
    private Date deletedAt;
}