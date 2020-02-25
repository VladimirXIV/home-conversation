package srv.converse.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Conversation.
 *
 * @author waldemar
 */
public class Conversation extends BaseEntity {

    private String title;
    private Long creatorId;
    private Collection<Participant> participants;
    private Collection<ArchivedConversation> archivedConversations;

    public Conversation() {
        this.participants = new ArrayList<>();
        this.archivedConversations = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Collection<Participant> getParticipants() {
        return participants;
    }

    public void addParticipant(Participant participant) {
        participant.setConversation(this);
        this.participants.add(participant);
    }

    public void addParticipants(Collection<Participant> participants) {
        for (Participant participant : participants) {
            addParticipant(participant);
        }
    }

    public Collection<ArchivedConversation> getArchivedConversations() {
        return archivedConversations;
    }

    public void addArchivedConversation(ArchivedConversation archivedConversation) {
        archivedConversation.setConversation(this);
        this.archivedConversations.add(archivedConversation);
    }

    public void addArchivedConversations(Collection<ArchivedConversation> archivedConversations) {
        for (ArchivedConversation archivedConversation : archivedConversations) {
            addArchivedConversation(archivedConversation);
        }
    }
}
