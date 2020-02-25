package srv.converse.dao;

import srv.converse.model.Conversation;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public interface ConversationDAO {
    public Long createConversation(Conversation conversation);
    public Collection<Conversation> retrieveAllConversations();
    public Conversation retrieveConversation(Long conversationId);
    public void updateConversation(Conversation newConversation);
    public void  deleteConversation(Long conversationId);
}
