package srv.converse.dao;

import srv.converse.model.Conversation;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public interface ConversationDAO {
    public void createConversation(Conversation conversation);
    public Collection<Conversation> retrieveAllConversations();
    public Conversation retrieveConversation(Long conversationId);
    public Conversation updateConversation(Conversation newConversation);
    public void removeConversation(Long id);
}
