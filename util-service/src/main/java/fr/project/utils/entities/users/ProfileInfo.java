package fr.project.utils.entities.users;

import fr.project.utils.entities.params.WorkType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     00:53
 */

@Data
@ToString
@Entity
public class ProfileInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToOne
    private ProfileAccount profileAccount;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String description;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Temporal(TemporalType.TIMESTAMP)
    private Date registration;
    @Column(nullable = false)
    private String dreamJobs;
}
