package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Demo1Application {

    private static final Logger logger = LogManager.getLogger(Demo1Application.class.getName());
    public static void main(String[] args) {

        logger.debug("this is a debug message");
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
        logger.fatal("this is a datal message");

        SpringApplication.run(Demo1Application.class, args);
    }

}
