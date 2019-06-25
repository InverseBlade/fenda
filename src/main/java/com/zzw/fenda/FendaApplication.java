package com.zzw.fenda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zzw.fenda.dao")
public class FendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FendaApplication.class, args);
    }

}
