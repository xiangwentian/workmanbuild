package com.source.workman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author liuzh
 */
//@ServletComponentScan(basePackages = "com.source.workman.traceid.filter")
@SpringBootApplication
public class WorkmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkmanApplication.class, args);
    }

}
