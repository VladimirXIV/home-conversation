package srv.converse.service;

import srv.converse.model.Report;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 16-Mar-20
 */
public interface ReportService {
    public void createReport(Report report);

    public void updateReport(Report report);

    public Report retreiveReport(Long reportId);

    public Collection<Report> retreiveAllReport();

    public void archiveReport(Long reportId);
}
