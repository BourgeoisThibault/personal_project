package fr.project.utils.entities.oldentities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author BOURGEOIS Thibault
 * Date     25/02/2018
 * Time     19:05
 */
@Data
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String mail;
    @Column
    private String pseudo;
    @Column
    private String password;
    @Column
    private String dateOfBirth;
    @ManyToOne
    private WorkEntity workEntity;
    @ManyToOne
    private Workplace workplace;
}
