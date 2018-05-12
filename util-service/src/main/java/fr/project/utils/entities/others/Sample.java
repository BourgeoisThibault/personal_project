package fr.project.utils.entities.others;

import lombok.Builder;
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
@Builder
@Entity
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String myString;
}
