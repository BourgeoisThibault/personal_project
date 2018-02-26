package fr.project.restservice.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author BOURGEOIS Thibault
 * Date     26/02/2018
 * Time     15:32
 */
@Data
@ToString
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @OneToOne
    private User user;
    @ManyToOne
    private Workplace workplace;
    @ManyToOne
    private WorkEntity workEntity;
}