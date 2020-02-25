package srv.converse.dao;

import srv.converse.model.ArchivedConversation;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public interface ArchivedConversationDAO {
    public void createDeletedConversationDAO(ArchivedConversation deletedConversation);
    public ArchivedConversation retrieveDeletedConversationDAO(int deletedConversationId);
    public ArchivedConversation updateDeletedConversationDAO(ArchivedConversation newdDletedConversation);
}
