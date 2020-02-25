package srv.converse.service;


import srv.converse.model.ArchivedConversation;

/**
 * @author vladimir.fedotov
 * @since 06-Dec-19
 */
public interface ArchivedConversationService {

    public void createDeletedConversation(ArchivedConversation deletedconversation);

    public ArchivedConversation retreiveDeletedConversation(int deletedConversationId);

    public void updateParticipant(ArchivedConversation deletedconversation);
}
