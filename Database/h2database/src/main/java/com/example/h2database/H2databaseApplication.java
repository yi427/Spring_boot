package com.example.h2database;

import com.example.h2database.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2databaseApplication {

    public static void main(String[] args) {

        SpringApplication.run(H2databaseApplication.class, args);
    }

}
