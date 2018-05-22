package fr.project.restservice.repositories.module;

import fr.project.utils.entities.module.ChatMessage;
import fr.project.utils.entities.module.ChatRoom;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatMessageRepo extends CrudRepository<ChatMessage, Long> {
    //List<ChatMessage> findAllByChatRoomOrderByDateSend(ChatRoom chatRoom);
}
