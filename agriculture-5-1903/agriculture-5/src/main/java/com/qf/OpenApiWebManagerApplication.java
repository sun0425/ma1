package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管理
public class OpenApiWebManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenApiWebManagerApplication.class, args);
    }
}
