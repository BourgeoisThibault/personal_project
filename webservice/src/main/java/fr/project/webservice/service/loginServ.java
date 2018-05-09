package fr.project.webservice.service;
import models.User_;
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

    public HttpStatus connectUser(String login, String pass){

        String finalUrl = linkREST + "user/checking";

        HttpHeaders headers = new HttpHeaders();
        headers.set("login", login);
        headers.set("pass", pass);
        HttpEntity entity = new HttpEntity("parameters",headers);

        try {
            restTemplate.exchange(finalUrl, GET, entity, String.class);
            return HttpStatus.OK;
        } catch (HttpClientErrorException ex) {
            return ex.getStatusCode();
        }
    }

    public User_ getUserInformations(String login) {
        return restTemplate.getForObject(linkREST + "user/login/" + login, User_.class);
    }

}
