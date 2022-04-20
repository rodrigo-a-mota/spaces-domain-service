package com.impactante.spaces.domain.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.impactante.spaces.domain")
@EnableJpaRepositories(basePackages = "com.impactante.spaces.domain")
@ComponentScan(basePackages = "com.impactante.spaces.domain")
@SpringBootApplication
public class Boot
{
    public static void main(String[] args)
    {
        SpringApplication.run(Boot.class, args);
    }
}