package fr.project.restservice.services.module;

import fr.project.restservice.repositories.module.ChatMessageRepo;
import fr.project.utils.entities.module.ChatMessage;
import fr.project.utils.entities.module.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     13/05/2018
 * Time     19:57
 */
@Service
public class ChatMessageService {

    /*
    @Autowired
    private ChatMessageRepo chatMessageRepo;

    public List<ChatMessage> getMessageByRoom(ChatRoom chatRoom){
        return (List<ChatMessage>)chatMessageRepo.findAllByChatRoomOrderByDateSend(chatRoom);
    }
    */
}
