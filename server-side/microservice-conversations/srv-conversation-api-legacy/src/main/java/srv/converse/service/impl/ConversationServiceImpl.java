package srv.converse.service.impl;

import srv.converse.dao.ArchivedConversationDAO;
import srv.converse.dao.ConversationDAO;
import srv.converse.model.ArchivedConversation;
import srv.converse.model.Conversation;
import srv.converse.service.ConversationService;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public class ConversationServiceImpl implements ConversationService {

    private ConversationDAO conversationDAO;
    private ArchivedConversationDAO archivedConversationDAO;

    public ConversationServiceImpl(ConversationDAO conversationDAO, ArchivedConversationDAO archivedConversationDAO) {
        this.conversationDAO = conversationDAO;
        this.archivedConversationDAO = archivedConversationDAO;
    }

    @Override
    public void createConversation(Conversation conversation) {
        conversationDAO.createConversation(conversation);
    }

    @Override
    public void updateConversation(Conversation conversation) {
        conversationDAO.updateConversation(conversation);
    }

    @Override
    public Conversation retreiveConversation(Long conversationId) {
        Conversation conversation = conversationDAO.retrieveConversation(conversationId);
        return conversation;
    }

    @Override
    public Collection<Conversation> retreiveAllConversation() {
        return conversationDAO.retrieveAllConversations();
    }

    @Override
    public void archiveConversation(Long conversationId) {
        ArchivedConversation archivedConversation = new ArchivedConversation();
        archivedConversationDAO.createDeletedConversationDAO(archivedConversation);
    }
}
