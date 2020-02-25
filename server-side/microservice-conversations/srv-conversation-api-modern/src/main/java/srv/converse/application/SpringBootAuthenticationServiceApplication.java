package srv.converse.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBootAuthenticationServiceApplication.
 *
 * @author waldemar
 */
@ComponentScan(basePackages = {"srv.converse.repository"})
@SpringBootApplication
public class SpringBootAuthenticationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAuthenticationServiceApplication.class, args);
    }

}