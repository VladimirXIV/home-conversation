/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.converse.model;

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
 * DeletedConversation.
 *
 * @author waldemar
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "deleted_conversation", schema = "srv_converse")
public class DeletedConversation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deletedConversationGen")
    @SequenceGenerator(name = "deletedConversationGen", schema = "srv_converse", sequenceName = "deleted_conversation_seq")
    private Long id;

    @Column(name = "conversation_id")
    private Long conversationId;

    @Column(name = "participant_id")
    private Long participantId;

    @Column(name = "created_at")
    private Date createdAt;
}