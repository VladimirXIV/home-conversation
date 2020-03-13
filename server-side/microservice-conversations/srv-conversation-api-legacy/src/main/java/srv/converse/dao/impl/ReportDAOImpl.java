package srv.converse.dao.impl;

import srv.converse.dao.ReportDAO;
import srv.converse.model.Conversation;
import srv.converse.model.Report;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 13-Mar-20
 */
public class ReportDAOImpl implements ReportDAO {

    private EntityManagerFactory entityManagerFactory;

    @Override
    public void createReport(Report report) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(participant);

        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Collection<Report> retrieveAllReports() {
        return null;
    }

    @Override
    public Report retrieveReport(Long reportId) {
        return null;
    }

    @Override
    public Report updateReport(Conversation newReport) {
        return null;
    }

    @Override
    public void removeReport(Long reportId) {

    }
}
