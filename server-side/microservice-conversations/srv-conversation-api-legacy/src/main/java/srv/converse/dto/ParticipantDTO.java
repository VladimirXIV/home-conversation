package srv.converse.dto;

import srv.converse.dao.ParticipantDAO;
import srv.converse.model.Participant;

import java.util.Date;

/**
 * @author vladimir.fedotov
 * @since 25-Feb-20
 */
public class ParticipantDTO {

    private Long id;
    private Long userId;
    private Long roleId;
    private Date updatedAt;
    private Date createdAt;

    public static ParticipantDTO fromParticipant(Participant participant) {
        ParticipantDTO participantDTO = new ParticipantDTO();

        participantDTO.setId(participant.getId());
        participantDTO.setUserId(participant.getUserId());
        participantDTO.setRoleId(participant.getRoleId());
        participantDTO.setCreatedAt(participant.getCreatedAt());
        participantDTO.setUpdatedAt(participant.getUpdatedAt());

        return participantDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
