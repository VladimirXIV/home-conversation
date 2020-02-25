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

/**
 * Participant.
 *
 * @author waldemar
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "participant", schema = "srv_converse")
public class Participant {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participantGen")
    @SequenceGenerator(name = "participantGen", schema = "srv_converse", sequenceName = "participant_seq")
    private Long id;

    @Column(name = "conversation_id")
    private Long conversationId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;
}