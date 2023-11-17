package com.example.log4j2_configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4j2ConfigureApplication {
    private static final Logger logger = LoggerFactory.getLogger(Log4j2ConfigureApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(Log4j2ConfigureApplication.class, args);
        logger.info("CourseTrackerApplication started successfully with Log4j2 configuration!");
    }

}
