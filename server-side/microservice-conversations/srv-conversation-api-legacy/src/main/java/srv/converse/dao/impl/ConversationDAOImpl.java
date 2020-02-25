package srv.converse.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import srv.converse.dao.ConversationDAO;
import srv.converse.model.Conversation;
import srv.converse.utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;


/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public class ConversationDAOImpl implements ConversationDAO {

    @Override
    public Long createConversation(Conversation conversation) {

        Long id = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            id = (Long)session.save(conversation);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return id;
    }

    @Override
    public Conversation retrieveConversation(Long conversationId) {
        Conversation conversation = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            conversation = session.get(Conversation.class, conversationId);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
        return conversation;
    }


    public Collection<Conversation> retrieveAllConversations() {

        Collection<Conversation> conversations = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Conversation> criteriaQuery = criteriaBuilder.createQuery(Conversation.class);
            criteriaQuery.from(Conversation.class);
            conversations = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }

        return conversations;
    }

    @Override
    public void updateConversation(Conversation conversation) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(conversation);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
    }

    @Override
    public void deleteConversation(Long conversationId) {

        Conversation conversation = retrieveConversation(conversationId);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.delete(conversation);

            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        }
    }
}
