package srv.converse.dao.impl;

import srv.converse.dao.ConversationDAO;
import srv.converse.model.Conversation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public class ConversationDAOImpl implements ConversationDAO {

    private EntityManagerFactory entityManagerFactory;

    public ConversationDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void createConversation(Conversation conversation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(conversation);

        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Conversation retrieveConversation(Long conversationId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Conversation conversation = entityManager.find(Conversation.class, conversationId);

        entityManager.close();

        return conversation;
    }

    public Collection<Conversation> retrieveAllConversations() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select conv FROM сonversation conv");

        return  (Collection<Conversation>) query.getResultList();
    }

    @Override
    public Conversation updateConversation(Conversation conversation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        conversation = entityManager.merge(conversation);

        entityTransaction.commit();
        entityManager.close();

        return conversation;
    }

    @Override
    public void removeConversation(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Conversation conversation = entityManager.find(Conversation.class, id);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(conversation); //delete
        entityTransaction.commit();

        entityManager.close();
    }
}
