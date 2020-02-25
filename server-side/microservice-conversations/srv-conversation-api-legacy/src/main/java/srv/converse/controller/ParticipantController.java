package srv.converse.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import srv.converse.dto.ParticipantDTO;
import srv.converse.model.Participant;
import srv.converse.service.ParticipantService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
@Controller
@RequestMapping(value = "/participant")
public class ParticipantController {

    private ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @RequestMapping(value = "/{participantId}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ParticipantDTO getParticipantById(@PathVariable int participantId) {
        Participant participant = participantService.retreiveParticipant(participantId);
        return ParticipantDTO.fromParticipant(participant);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateParticipant(Participant participant) {
        participantService.updateParticipant(participant);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createConversation(@RequestBody Participant participant) {
        participantService.createParticipant(participant);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteConversation(@PathVariable int participantId) {
        participantService.deleteParticipant(participantId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ParticipantDTO> findAllParticipants() {
        Collection<Participant> participants = participantService.retreiveAllParticipants();
        Collection<ParticipantDTO> participantDTOs = new ArrayList<>();
        for (Participant participant : participants) {
            participantDTOs.add(ParticipantDTO.fromParticipant(participant));
        }
        return participantDTOs;
    }
}
