/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package srv.auth.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBootAuthenticationServiceApplication.
 *
 * @author waldemar
 */
@ComponentScan(basePackages = {"srv.auth.config",
                               "srv.auth.controller",
                               "srv.auth.service",
                               "srv.auth.repository"
                                })
public class SpringBootAuthenticationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAuthenticationServiceApplication.class, args);
    }

}