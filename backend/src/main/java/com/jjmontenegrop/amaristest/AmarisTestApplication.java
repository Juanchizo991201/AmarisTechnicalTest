package com.jjmontenegrop.amaristest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AmarisTestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AmarisTestApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AmarisTestApplication.class);
    }
}
