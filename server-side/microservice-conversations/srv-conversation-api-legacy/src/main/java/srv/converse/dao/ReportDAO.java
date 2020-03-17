package srv.converse.dao;

import srv.converse.model.Conversation;
import srv.converse.model.Report;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 13-Mar-20
 */
public interface ReportDAO {
    public void createReport(Report report);
    public Collection<Report> retrieveAllReports();
    public Report retrieveReport(Long reportId);
    public Report updateReport(Report newReport);
    public void removeReport(Long reportId);
}
