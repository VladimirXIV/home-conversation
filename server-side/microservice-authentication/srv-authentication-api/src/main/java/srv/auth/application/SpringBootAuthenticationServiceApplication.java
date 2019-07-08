/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * SpringBootAuthenticationServiceApplication.
 *
 * @author waldemar
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"srv.auth.config",
                               "srv.auth.controller",
                               "srv.auth.service",
                               "srv.auth.security"
                                })
@EnableJpaRepositories(basePackages = {"srv.auth.repository"})
@EntityScan(basePackages = {"srv.auth.model"})
public class SpringBootAuthenticationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAuthenticationServiceApplication.class, args);
    }

}