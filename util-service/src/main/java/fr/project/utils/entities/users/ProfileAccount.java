package fr.project.utils.entities.users;

import fr.project.utils.entities.params.ProfileType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     00:51
 */

@Data
@ToString
@Entity
public class ProfileAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String pseudo;
    @Column
    private String mail;
    @Column
    private String encryptedPass;
    @OneToOne
    private ProfileType profileType;
}
