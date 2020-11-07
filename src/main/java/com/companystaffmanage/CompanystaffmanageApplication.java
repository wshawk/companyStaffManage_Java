package com.companystaffmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
//@SpringBootApplication
@MapperScan("com.companystaffmanage.*")
public class CompanystaffmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanystaffmanageApplication.class, args);
    }

}
