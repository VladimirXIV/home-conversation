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
    public void createArchivedConversation(ArchivedConversation archivedConversation) {
        archivedConversationDAO.createArchivedConversationDAO(archivedConversation);
    }

    @Override
    public ArchivedConversation retrieveArchivedConversation(Long archivedConversationId) {
        return archivedConversationDAO.retrieveArchivedConversationDAO(archivedConversationId);
    }

    @Override
    public void updateArchivedConversation(ArchivedConversation archivedConversation) {
        archivedConversationDAO.updateArchivedConversationDAO(archivedConversation);
    }
}
