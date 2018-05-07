package fr.project.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author BOURGEOIS Thibault
 * Date     04/05/2018
 * Time     11:43
 */

@SpringBootApplication
public class WebApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApp.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }

}
