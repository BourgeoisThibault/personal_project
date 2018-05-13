package fr.project.utils.entities.params;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author BOURGEOIS Thibault
 * Date     12/05/2018
 * Time     15:56
 */

@Data
@ToString
@Entity
public class WorkType {
    @Id
    @Column
    private String wording;
}
