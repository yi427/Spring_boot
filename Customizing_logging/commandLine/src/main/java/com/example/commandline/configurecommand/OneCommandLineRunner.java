package com.example.commandline.configurecommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(1)
@Component
public class OneCommandLineRunner implements CommandLineRunner {
    final Logger logger =  LoggerFactory.getLogger(getClass());
    @Override
    public void run(String... args) throws Exception {
        logger.info("MyCommandLinerRunner executed as a Spring Component");
    }
}
