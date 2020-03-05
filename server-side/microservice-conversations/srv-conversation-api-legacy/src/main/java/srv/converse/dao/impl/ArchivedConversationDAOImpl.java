package srv.converse.dao.impl;

import srv.converse.dao.ArchivedConversationDAO;
import srv.converse.model.ArchivedConversation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public class ArchivedConversationDAOImpl implements ArchivedConversationDAO {

    private EntityManagerFactory entityManagerFactory;

    public ArchivedConversationDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conversationUnit");
    }

    @Override
    public void createDeletedConversationDAO(ArchivedConversation archivedConversation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(archivedConversation);

        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public ArchivedConversation retrieveDeletedConversationDAO(int archivedConversationId) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ArchivedConversation deletedConversation = entityManager.find(ArchivedConversation.class, archivedConversationId);

        entityManager.close();

        return deletedConversation;
    }

    @Override
    public ArchivedConversation updateDeletedConversationDAO(ArchivedConversation archivedConversation) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        archivedConversation = entityManager.merge(archivedConversation);

        entityTransaction.commit();
        entityManager.close();

        return archivedConversation;
    }
}
