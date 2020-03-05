package srv.converse.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import srv.converse.model.Conversation;

/**
 * @author vladimir.fedotov
 * @since 25-Feb-20
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/application-context.xml")
public class ConversationControllerTest {

    @Test
    public void createConversationSuccessfulTest() {

        final String uri = "http://localhost:8080/conversation/create";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Conversation> entity = new HttpEntity<>(null);

        ResponseEntity<Void> response = restTemplate.exchange(uri, HttpMethod.POST, entity, Void.class);

        Assert.assertNotNull(response);
    }

}
