package fr.project.restservice.services.module;

import fr.project.restservice.repositories.module.ChatRoomRepo;
import fr.project.utils.entities.module.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     13/05/2018
 * Time     17:16
 */
@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepo chatRoomRepo;

    public List<ChatRoom> getAllChatRoom(){
        return (List<ChatRoom>)chatRoomRepo.findAll();
    }

    public ChatRoom getChatRoomById(Long id){
        return chatRoomRepo.findOne(id);
    }
}
