package fr.project.restservice.controllers.module;

import fr.project.restservice.services.module.ChatMessageService;
import fr.project.restservice.services.module.ChatRoomService;
import fr.project.utils.entities.module.ChatMessage;
import fr.project.utils.entities.module.ChatRoom;
import fr.project.utils.entities.users.ProfileAccount;
import fr.project.utils.entities.users.ProfileInfo;
import fr.project.utils.methods.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     13/05/2018
 * Time     17:18
 */
@RestController
@RequestMapping("/chat/room")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping(value = "/all")
    public ResponseEntity getAllRoom() {
        try {

            List<ChatRoom> chatRoomList = chatRoomService.getAllChatRoom();

            if(chatRoomList == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity(chatRoomList,HttpStatus.UNAUTHORIZED);

        } catch (HttpClientErrorException ex) {
            return new ResponseEntity(ex.getStatusCode());
        }

    }

    @GetMapping(value = "/{chatRoomId}")
    public ResponseEntity getAllMessages(
            @PathVariable long chatRoomId) {
        try {

            ChatRoom chatRoom = chatRoomService.getChatRoomById(chatRoomId);

            if(chatRoom == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity(chatRoom,HttpStatus.OK);

        } catch (HttpClientErrorException ex) {
            return new ResponseEntity(ex.getStatusCode());
        }

    }

}
