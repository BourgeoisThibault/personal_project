package fr.project.utils.entities.switchoffer;

import fr.project.utils.entities.users.ProfileInfo;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     21/05/2018
 * Time     13:26
 */

@Data
@ToString
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToOne
    private ProfileInfo profileInfo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBegin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;
    @Column
    private String offer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;
    @Column
    private String comment;
    @Column
    private String location;
    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private Boolean isMatch;
    @OneToMany
    private List<ProfileInfo> listOfLike;
}
