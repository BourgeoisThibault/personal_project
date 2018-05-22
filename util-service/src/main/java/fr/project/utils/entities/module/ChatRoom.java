package fr.project.utils.entities.module;

import fr.project.utils.entities.users.ProfileAccount;
import fr.project.utils.entities.users.ProfileInfo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     13/05/2018
 * Time     17:08
 */
@Data
@ToString
@Entity
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToMany
    private List<ProfileInfo> profileInfoList;
    @Column
    private String roomName;
    @OneToMany
    private List<ChatMessage> chatMessageList;

}
