package srv.converse.dao;

import srv.converse.model.ArchivedConversation;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public interface ArchivedConversationDAO {
    public void createArchivedConversationDAO(ArchivedConversation archivedConversation);
    public ArchivedConversation retrieveArchivedConversationDAO(Long archivedConversationId);
    public ArchivedConversation updateArchivedConversationDAO(ArchivedConversation newdArchivedConversation);
}
