package fr.project.utils.entities.switchoffer;

import fr.project.utils.entities.module.ChatRoom;
import fr.project.utils.entities.users.ProfileInfo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author BOURGEOIS Thibault
 * Date     21/05/2018
 * Time     17:35
 */

@Data
@ToString
@Entity
public class OfferValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToOne
    private Offer offer;
    @OneToOne
    private ProfileInfo acceptor;
    @OneToOne
    private ChatRoom chatRoom;
    @Column(columnDefinition = "INT DEFAULT 0")
    private int nbValidation;
}
