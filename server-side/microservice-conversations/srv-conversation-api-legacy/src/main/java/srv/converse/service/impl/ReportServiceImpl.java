package srv.converse.service.impl;

import srv.converse.dao.ReportDAO;
import srv.converse.model.Report;
import srv.converse.service.ReportService;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 16-Mar-20
 */
public class ReportServiceImpl implements ReportService {

    private ReportDAO reportDAO;

    public ReportServiceImpl(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }

    @Override
    public void createReport(Report report) {
        reportDAO.createReport(report);
    }

    @Override
    public void updateReport(Report report) {
        reportDAO.updateReport(report);
    }

    @Override
    public Report retreiveReport(Long reportId) {
        return reportDAO.retrieveReport(reportId);
    }

    @Override
    public Collection<Report> retreiveAllReport() {
        return reportDAO.retrieveAllReports();
    }

    @Override
    public void archiveReport(Long conversationId) {

    }
}
