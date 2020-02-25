package srv.converse.dao;

import srv.converse.model.Participant;
import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public interface ParticipantDAO {
    public void createParticipant(Participant participant);
    public Participant retrieveParticipant(int participantId);
    public Participant updateParticipant(Participant participant);
    public void  deleteParticipant(int participantId);
    public Collection<Participant> retrieveAllParticipants();
}
