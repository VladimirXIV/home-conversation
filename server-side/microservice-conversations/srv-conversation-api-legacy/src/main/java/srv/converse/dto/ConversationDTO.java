package srv.converse.dto;

import srv.converse.model.Conversation;

import java.util.Date;

/**
 * @author vladimir.fedotov
 * @since 25-Feb-20
 */
public class ConversationDTO {

    private Long id;
    private String title;
    private Long creatorId;
    private Date updatedAt;
    private Date createdAt;

    public static ConversationDTO fromConversation(Conversation conversation) {

        ConversationDTO conversationDTO = new ConversationDTO();

        conversationDTO.setId(conversation.getId());
        conversationDTO.setTitle(conversation.getTitle());
        conversationDTO.setCreatorId(conversation.getCreatorId());
        conversationDTO.setCreatedAt(conversation.getCreatedAt());
        conversationDTO.setUpdatedAt(conversation.getUpdatedAt());

        return conversationDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
