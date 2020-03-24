package com.cerr.school_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.cerr.school_api.dao")
@SpringBootApplication
public class SchoolApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApiApplication.class, args);
    }

}
