package srv.converse.service;


import srv.converse.model.ArchivedConversation;

/**
 * @author vladimir.fedotov
 * @since 06-Dec-19
 */
public interface ArchivedConversationService {

    public void createArchivedConversation(ArchivedConversation archivedConversation);

    public ArchivedConversation retrieveArchivedConversation(Long archivedConversationId);

    public void updateArchivedConversation(ArchivedConversation archivedConversation);
}
