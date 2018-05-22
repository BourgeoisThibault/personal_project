package fr.project.utils.entities.module;

import fr.project.utils.entities.users.ProfileInfo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author BOURGEOIS Thibault
 * Date     13/05/2018
 * Time     17:40
 */
@Data
@ToString
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String message;
    @OneToOne
    private ProfileInfo sender;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSend;
}
