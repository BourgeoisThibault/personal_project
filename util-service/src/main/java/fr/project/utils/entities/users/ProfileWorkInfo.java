package fr.project.utils.entities.users;

import fr.project.utils.entities.params.WorkingDepartment;
import fr.project.utils.entities.params.WorkingLocation;
import fr.project.utils.entities.params.WorkType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     00:56
 */

@Data
@ToString
@Entity
public class ProfileWorkInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToOne
    private ProfileInfo profileInfo;
    @Column
    private String workLibelle;
    @ManyToOne
    private WorkType workType;
    @ManyToOne
    private WorkingDepartment workEntity;
    @ManyToOne
    private WorkingLocation workingLocation;
    @Temporal(TemporalType.DATE)
    private Date hiringDate;
    @ElementCollection
    private List<WorkType> interestJob;

}
