package com.jeremw.hexagonal;

import com.jeremw.hexagonal.annotation.ServicePort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "com.jeremw.hexagonal", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {ServicePort.class}))
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
