package srv.converse.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import srv.converse.dto.ArchivedConversationDTO;
import srv.converse.model.ArchivedConversation;
import srv.converse.service.ArchivedConversationService;

/**
 * @author vladimir.fedotov
 * @since 16-Mar-20
 */
@Controller
@RequestMapping(value = "/archived")
public class ArchivedConversationController {

    private ArchivedConversationService archivedConversationService;

    public ArchivedConversationController(ArchivedConversationService archivedConversationService) {
        this.archivedConversationService = archivedConversationService;
    }

    @ResponseBody
    @RequestMapping(value = "/{archivedConversationId}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ArchivedConversationDTO getArchivedConversationById(@PathVariable Long archivedConversationId) {
        ArchivedConversation archivedConversation = archivedConversationService.retrieveArchivedConversation(archivedConversationId);
        return ArchivedConversationDTO.fromArchivedConversation(archivedConversation);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateArchivedConversation(@RequestBody ArchivedConversation archivedConversation) {
        archivedConversationService.updateArchivedConversation(archivedConversation);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createArchivedConversation(@RequestBody ArchivedConversation archivedConversation) {
        archivedConversationService.createArchivedConversation(archivedConversation);
    }
}
