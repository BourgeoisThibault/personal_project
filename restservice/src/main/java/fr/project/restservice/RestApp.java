package fr.project.restservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BOURGEOIS Thibault
 * Date     20/02/2018
 * Time     22:34
 */
@SpringBootApplication
public class RestApp {

    public static void main(String[] args) {
        // close the application context to shut down the custom ExecutorService
        SpringApplication.run(RestApp.class, args);
    }
}
