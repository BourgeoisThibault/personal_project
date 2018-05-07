package fr.project.webservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

/**
 * @author BOURGEOIS Thibault
 * Date     08/05/2018
 * Time     00:14
 */
@Service
public class loginServ {

    @Value("${link.rest}")
    private String linkREST;

    private RestTemplate restTemplate = new RestTemplate();

    public Boolean connectUser(String login, String pass){

        String finalUrl = linkREST + "login/checking";

        HttpHeaders headers = new HttpHeaders();
        headers.set("login", login);
        headers.set("pass", pass);
        HttpEntity entity = new HttpEntity("parameters",headers);

        try {
            restTemplate.exchange(finalUrl, GET, entity, String.class);
            return true;
        } catch (HttpClientErrorException ex) {
            return false;
        }
    }

}
