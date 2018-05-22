package fr.project.restservice.repositories.module;

import fr.project.utils.entities.module.ChatRoom;
import fr.project.utils.entities.users.ProfileAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     13/05/2018
 * Time     17:15
 */

public interface ChatRoomRepo extends CrudRepository<ChatRoom, Long> {
}
