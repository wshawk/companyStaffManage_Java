package com.hawk.company_staff_manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hawk.company_staff_manage.**.mapper")
public class CompanyStaffManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyStaffManageApplication.class, args);
    }

}
