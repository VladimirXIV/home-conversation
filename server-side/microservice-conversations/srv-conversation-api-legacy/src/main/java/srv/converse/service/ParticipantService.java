package srv.converse.service;

import srv.converse.model.Participant;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public interface ParticipantService {

    public void createParticipant(Participant participant);

    public Participant retreiveParticipant(int participantId);

    public void updateParticipant(Participant participant);

    public void deleteParticipant(int participantId);

    public Collection<Participant> retreiveAllParticipants();
}
