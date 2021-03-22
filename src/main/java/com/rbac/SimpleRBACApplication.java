package com.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SimpleRBACApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleRBACApplication.class, args);
    }

}
