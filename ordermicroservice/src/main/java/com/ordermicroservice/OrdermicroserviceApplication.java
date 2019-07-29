package com.ordermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class OrdermicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdermicroserviceApplication.class, args);
    }

}
