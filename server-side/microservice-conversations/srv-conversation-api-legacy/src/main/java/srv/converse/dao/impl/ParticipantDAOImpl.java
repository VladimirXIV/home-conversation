package srv.converse.dao.impl;

import srv.converse.dao.ParticipantDAO;
import srv.converse.model.Participant;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public class ParticipantDAOImpl implements ParticipantDAO {

    private EntityManagerFactory entityManagerFactory;

    public ParticipantDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("conversationUnit");
    }

    @Override
    public void createParticipant(Participant participant) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(participant);

        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Participant retrieveParticipant(int participantId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Participant participant = entityManager.find(Participant.class, participantId);

        entityManager.close();

        return participant;
    }

    @Override
    public Participant updateParticipant(Participant participant) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        participant = entityManager.merge(participant);

        entityTransaction.commit();
        entityManager.close();

        return participant;
    }

    @Override
    public void deleteParticipant(int participantId) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Participant participant = entityManager.find(Participant.class, participantId);
        entityManager.remove(participant);

        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Collection<Participant> retrieveAllParticipants() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select p FROM participant p");

        return  (Collection<Participant>) query.getResultList();
    }
}
