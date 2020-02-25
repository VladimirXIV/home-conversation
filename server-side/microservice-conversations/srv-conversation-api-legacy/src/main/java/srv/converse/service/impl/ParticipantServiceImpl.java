package srv.converse.service.impl;

import srv.converse.dao.ParticipantDAO;
import srv.converse.model.Participant;
import srv.converse.service.ParticipantService;

import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantDAO participantDAO;

    public ParticipantServiceImpl(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @Override
    public void createParticipant(Participant participant) {
        participantDAO.createParticipant(participant);
    }

    @Override
    public void updateParticipant(Participant participant) {
        participantDAO.updateParticipant(participant);
    }

    @Override
    public Participant retreiveParticipant(int participantId) {
        return participantDAO.retrieveParticipant(participantId);
    }

    @Override
    public void deleteParticipant(int participantId) {
        participantDAO.deleteParticipant(participantId);
    }

    @Override
    public Collection<Participant> retreiveAllParticipants() {
        return participantDAO.retrieveAllParticipants();
    }
}
