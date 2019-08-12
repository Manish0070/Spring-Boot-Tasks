package com.stackroute.trackservice;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class TrackServiceApplication {
    private static Logger logger= LoggerFactory.getLogger(TrackServiceApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(TrackServiceApplication.class, args);
        logger.debug("This Is debug");
        logger.error("Error Message");
        logger.info("This Is Info");
    }

}
