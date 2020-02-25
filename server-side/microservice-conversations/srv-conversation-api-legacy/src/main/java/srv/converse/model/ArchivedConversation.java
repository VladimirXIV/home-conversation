package srv.converse.model;

/**
 * DeletedConversation.
 *
 * @author waldemar
 */
public class ArchivedConversation extends BaseEntity {

    private Long participantId;
    private Conversation conversation;

    public ArchivedConversation() {
    }

    public ArchivedConversation(Long participantId) {
        this.participantId = participantId;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
