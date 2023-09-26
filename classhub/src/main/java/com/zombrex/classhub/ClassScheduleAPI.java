package com.zombrex.classhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for starting the Class Schedule API application.
 * 
 * @author usuariozombie
 */
@SpringBootApplication
public class ClassScheduleAPI {

    /**
     * The main entry point for the Class Schedule API application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(ClassScheduleAPI.class, args);
    }
}
