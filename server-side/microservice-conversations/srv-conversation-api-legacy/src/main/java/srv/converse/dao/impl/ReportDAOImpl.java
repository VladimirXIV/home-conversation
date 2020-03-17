package srv.converse.dao.impl;

import srv.converse.dao.ReportDAO;
import srv.converse.model.Report;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 13-Mar-20
 */
public class ReportDAOImpl implements ReportDAO {

    private EntityManagerFactory entityManagerFactory;

    public ReportDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void createReport(Report report) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(report);

        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Collection<Report> retrieveAllReports() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select r FROM report r");

        return  (Collection<Report>) query.getResultList();
    }

    @Override
    public Report retrieveReport(Long reportId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Report report = entityManager.find(Report.class, reportId);

        entityManager.close();

        return report;
    }

    @Override
    public Report updateReport(Report newReport) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        newReport = entityManager.merge(newReport);

        entityTransaction.commit();
        entityManager.close();

        return newReport;
    }

    @Override
    public void removeReport(Long reportId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Report report = entityManager.find(Report.class, reportId);
        entityManager.remove(report);

        entityTransaction.commit();
        entityManager.close();
    }
}
