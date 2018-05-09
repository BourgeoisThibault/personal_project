package models;

import lombok.Data;
import lombok.ToString;

/**
 * @author BOURGEOIS Thibault
 * Date     09/05/2018
 * Time     23:27
 */

@Data
@ToString
public class User_ {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private String pseudo;
    private String password;
    private String dateOfBirth;
    private WorkEntity_ workEntity;
    private Workplace_ workplace;
}
