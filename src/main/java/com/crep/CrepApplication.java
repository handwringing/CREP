package com.crep;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.crep"}, annotationClass = Mapper.class)

public class CrepApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrepApplication.class, args);
    }

}
