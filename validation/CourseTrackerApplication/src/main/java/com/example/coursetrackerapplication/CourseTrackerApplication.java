package com.example.coursetrackerapplication;

import com.example.coursetrackerapplication.entity.Course;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;


@SpringBootApplication
public class CourseTrackerApplication {
    private final Logger logger = LoggerFactory.getLogger(CourseTrackerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CourseTrackerApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Course course = new Course();
            course.setId(1);
            course.setRating(0);
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            // Set<ConstraintViolation<Course>> violations = validator.validate(course);
            var violations = validator.validate(course);
            violations.forEach(courseConstraintViolation -> logger.error(
                    "A Constraint violation has occurred. Violation details: [{}].", courseConstraintViolation));
        };
    }

}
