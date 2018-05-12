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
 * Time     01:02
 */

@Data
@ToString
@Builder
@Entity
public class ProfileType {
    @Id
    @Column
    private String wording;
}
