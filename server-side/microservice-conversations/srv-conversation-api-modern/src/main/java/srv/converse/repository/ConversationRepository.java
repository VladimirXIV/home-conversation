package srv.converse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import srv.converse.model.Conversation;

/**
 * ConversationRepository.
 *
 * @author waldemar
 */
@Repository(value = "conversationRepository")
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
}