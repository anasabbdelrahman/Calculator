package se.tele2.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main class to start the Spring Boot Calculator application.
 */
@SpringBootApplication
@EnableJpaRepositories("se.tele2.calculator.repository")
@EntityScan("se.tele2.calculator.model")
public class CalculatorApplication {
    /**
     * The main method which acts as the entry point for the Spring Boot application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}
