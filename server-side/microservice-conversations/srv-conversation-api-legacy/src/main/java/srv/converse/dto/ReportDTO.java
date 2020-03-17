package srv.converse.dto;

import srv.converse.model.Participant;
import srv.converse.model.Report;

import java.util.Date;

/**
 * @author vladimir.fedotov
 * @since 16-Mar-20
 */
public class ReportDTO {

    private Long id;
    private String note;
    private String reportType;
    private Long userId;
    private Date updatedAt;

    public static ReportDTO fromReport(Report report) {

        ReportDTO reportDTO = new ReportDTO();

        reportDTO.setId(report.getId());
        reportDTO.setNote(report.getNote());
        reportDTO.setReportType(report.getReportType());
        reportDTO.setUserId(report.getUserId());
        reportDTO.setUpdatedAt(report.getUpdatedAt());

        return reportDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
