package br.com.covid.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.covid.*"})
@EnableJpaRepositories
public class CovidCombateApplication {
    public static void main(String[] args) {
        SpringApplication.run(CovidCombateApplication.class, args);
    }
}
