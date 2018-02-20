package fr.project.restservice.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author BOURGEOIS Thibault
 * Date     20/02/2018
 * Time     22:49
 */
@Data
@ToString
@Entity
@Table(name="sample")
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;
    @Column(name = "myString")
    private String myString;
}
