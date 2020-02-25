package srv.converse.service.impl;

import srv.converse.dao.ArchivedConversationDAO;
import srv.converse.model.ArchivedConversation;
import srv.converse.service.ArchivedConversationService;

/**
 * @author vladimir.fedotov
 * @since 06-Dec-19
 */
public class ArchivedConversationServiceImpl implements ArchivedConversationService {

    private ArchivedConversationDAO archivedConversationDAO;

    public ArchivedConversationServiceImpl(ArchivedConversationDAO archivedConversationDAO) {
        this.archivedConversationDAO = archivedConversationDAO;
    }

    @Override
    public void createDeletedConversation(ArchivedConversation archivedConversation) {
        archivedConversationDAO.createDeletedConversationDAO(archivedConversation);
    }

    @Override
    public ArchivedConversation retreiveDeletedConversation(int archivedConversationId) {
        return archivedConversationDAO.retrieveDeletedConversationDAO(archivedConversationId);
    }

    @Override
    public void updateParticipant(ArchivedConversation archivedConversation) {
        archivedConversationDAO.updateDeletedConversationDAO(archivedConversation);
    }
}
