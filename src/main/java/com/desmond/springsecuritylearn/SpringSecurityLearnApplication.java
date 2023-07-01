package com.desmond.springsecuritylearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.desmond.springsecuritylearn.mapper")
public class SpringSecurityLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityLearnApplication.class, args);
    }

}
