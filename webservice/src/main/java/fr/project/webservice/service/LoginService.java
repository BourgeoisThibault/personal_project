package fr.project.webservice.service;
import fr.project.utils.entities.oldentities.User;
import fr.project.utils.entities.users.ProfileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

/**
 * @author BOURGEOIS Thibault
 * Date     08/05/2018
 * Time     00:14
 */
@Service
public class LoginService {

    @Value("${link.rest}")
    private String linkREST;

    private RestTemplate restTemplate = new RestTemplate();

    public void sendNewPassword(String mail) {

    }

    public ProfileInfo authentificateUser(String login, String pass) throws Exception {

        String finalUrl = linkREST + "account/login/authentification";

        HttpHeaders headers = new HttpHeaders();
        headers.set("login", login);
        headers.set("pass", pass);
        HttpEntity entity = new HttpEntity("parameters",headers);

        try{
            ResponseEntity responseEntity = restTemplate.exchange(finalUrl, GET, entity, ProfileInfo.class);
            return (ProfileInfo)responseEntity.getBody();
        }catch (HttpStatusCodeException ex){
            String errorMsg;
            switch (ex.getStatusCode().value()) {
                case 404:
                    errorMsg = "Utilisateur inconnu";
                    break;
                case 401:
                    errorMsg = "Mauvais mot de passe";
                    break;
                default:
                    errorMsg = "Erreur inconnu";
                    break;
            }
            throw new Exception(errorMsg);
        }
    }

}
