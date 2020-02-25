package srv.converse.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import srv.converse.dto.ConversationDTO;
import srv.converse.model.Conversation;
import srv.converse.service.ConversationService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author vladimir.fedotov
 * @since 03-Dec-19
 */
@Controller
@RequestMapping(value = "/conversation")
public class ConversationController {

    private ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @ResponseBody
    @RequestMapping(value = "/{conversationId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ConversationDTO getConversationById(@PathVariable Long conversationId) {
        Conversation conversation = conversationService.retreiveConversation(conversationId);
        return ConversationDTO.fromConversation(conversation);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateConversation(@RequestBody Conversation conversation) {
        conversationService.updateConversation(conversation);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createConversation(@RequestBody Conversation conversation) {
        conversationService.createConversation(conversation);
    }

    @RequestMapping(value = "/archive/{conversationId}", method = RequestMethod.DELETE)
    public void createConversation(@PathVariable Long conversationId) {
        conversationService.archiveConversation(conversationId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ConversationDTO> findAllConversations() {
        Collection<Conversation> conversations = conversationService.retreiveAllConversation();
        Collection<ConversationDTO> conversationDTOs = new ArrayList<>();
        for (Conversation conversation : conversations) {
            conversationDTOs.add(ConversationDTO.fromConversation(conversation));
        }
        return conversationDTOs;
    }
}
