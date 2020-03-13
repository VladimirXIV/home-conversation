package srv.converse.model;

import java.util.Collection;
import java.util.Date;

/**
 * Participant.
 *
 * @author waldemar
 */
public class Participant extends BaseEntity {

    private Long userId;
    private Long roleId;
    private Date updatedAt;
    private Conversation conversation;
    private Collection<Report> reports;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Collection<Report> getReports() {
        return this.reports;
    }

    public void addReport(Report report) {
        report.setParticipant(this);
        this.reports.add(report);
    }

    public void addReports(Collection<Report> reports) {
        for (Report report : reports) {
            addReport(report);
        }
    }
}
