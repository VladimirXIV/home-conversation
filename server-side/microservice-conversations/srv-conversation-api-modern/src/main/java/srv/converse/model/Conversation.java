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
 * Conversation.
 *
 * @author waldemar
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "conversation", schema = "srv_converse")
public class Conversation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "converseGen")
    @SequenceGenerator(name = "converseGen", schema = "srv_converse", sequenceName = "conversation_seq")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}