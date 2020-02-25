package srv.converse.dto;

import srv.converse.model.ArchivedConversation;

import java.util.Date;

/**
 * @author vladimir.fedotov
 * @since 25-Feb-20
 */
public class ArchivedConversationDTO {

    private Long id;
    private Long participantId;

    private Date updatedAt;
    private Date createdAt;

    static ArchivedConversationDTO fromArchivedConversation(ArchivedConversation archivedConversation) {

        ArchivedConversationDTO archivedConversationDTO = new ArchivedConversationDTO();

        archivedConversationDTO.setId(archivedConversation.getId());
        archivedConversationDTO.setParticipantId(archivedConversation.getParticipantId());

        archivedConversationDTO.setCreatedAt(archivedConversation.getCreatedAt());
        archivedConversationDTO.setUpdatedAt(archivedConversation.getUpdatedAt());

        return archivedConversationDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
