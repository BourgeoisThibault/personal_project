package fr.project.utils.entities.users;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     00:53
 */

@Data
@ToString
@Builder
@Entity
public class ProfileInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToOne
    private ProfileAccount profileAccount;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Temporal(TemporalType.TIMESTAMP)
    private Date registration;
}
