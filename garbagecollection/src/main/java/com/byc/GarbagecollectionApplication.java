package com.byc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(value = "com.byc.mapper")
@SpringBootApplication
public class GarbagecollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarbagecollectionApplication.class, args);
    }

}
