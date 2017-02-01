package com.jefersonmachado.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.jefersonmachado")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}