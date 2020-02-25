package srv.converse.service;

import srv.converse.model.Conversation;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */

public interface ConversationService {

    public void createConversation(Conversation conversation);

    public void updateConversation(Conversation conversation);

    public Conversation retreiveConversation(Long conversationId);

    public Collection<Conversation> retreiveAllConversation();

    public void archiveConversation(Long conversationId);
}
