package com.example.commandline;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandLineApplication {

    final Log logger = LogFactory.getLog(CommandLineApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CommandLineApplication.class, args);
    }
    /*
    The second method for the bean definition
     */
    @Bean
    public CommandLineRunner commandLineRunner () {
        return args -> {
            logger.info("CommandLineRunner executed as a bean definition with " + args.length + " arguments");
            for (var i : args)
                logger.info("Argument: " + i);
        };
    }

    /*
    The first method for implement CommandLineRunner
    You need to implements it and Override the `run` method
    @Override
    public void run(String... args) throws Exception {
        logger.info("CourseTrackerApplication CommandLineRunner has executed");
    } */
}
