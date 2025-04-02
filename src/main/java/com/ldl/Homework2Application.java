package com.ldl;

import com.ldl.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 指定扫描的包路径
public class Homework2Application {
    public static void main(String[] args) {
        SpringApplication.run(Homework2Application.class, args);
    }

}
