package com.itemmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class ItemmicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemmicroserviceApplication.class, args);
    }

}
