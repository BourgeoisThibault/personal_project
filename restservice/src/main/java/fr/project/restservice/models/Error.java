package fr.project.restservice.models;

import lombok.Data;
import lombok.ToString;

/**
 * @author BOURGEOIS Thibault
 * Date     02/03/2018
 * Time     02:37
 */
@Data
@ToString
public class Error {
    String code;
    String reason;

    public Error(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

}
