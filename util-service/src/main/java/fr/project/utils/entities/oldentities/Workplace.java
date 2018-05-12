package fr.project.utils.entities.oldentities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     15:23
 */
@Data
@ToString
@Entity
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String wording;
}
