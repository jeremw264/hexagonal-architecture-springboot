package com.jeremw.hexagonal;

import com.jeremw.hexagonal.annotation.ServicePort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * Main entry point for the Book application.
 * <p>
 * This class serves as the starting point for the Spring Boot application,
 * enabling auto-configuration and component scanning for beans marked with
 * the {@link ServicePort} annotation. It launches the application context
 * and initializes the necessary components to run the application.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 26/10/2024
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.jeremw.hexagonal", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {ServicePort.class}))
public class BookApplication {

    /**
     * The main method that serves as the entry point for the application.
     *
     * @param args command-line arguments passed during application startup.
     */
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
