package fr.project.webservice.service;

import fr.project.utils.entities.module.ChatRoom;
import fr.project.utils.entities.users.ProfileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

/**
 * @author BOURGEOIS Thibault
 * Date     13/05/2018
 * Time     21:22
 */
@Service
public class MessageService {

    @Value("${link.rest}")
    private String linkREST;

    private RestTemplate restTemplate = new RestTemplate();

    public ChatRoom getChatRoom() throws Exception {
        String finalUrl = linkREST + "chat/room/1";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity("parameters",headers);

        try{
            ResponseEntity responseEntity = restTemplate.exchange(finalUrl, GET, entity, ChatRoom.class);
            return (ChatRoom) responseEntity.getBody();
        }catch (HttpStatusCodeException ex){
            String errorMsg;
            switch (ex.getStatusCode().value()) {
                case 404:
                    errorMsg = "Chat room inconnu";
                    break;
                default:
                    errorMsg = "Erreur inconnu";
                    break;
            }
            throw new Exception(errorMsg);
        }
    }
}
