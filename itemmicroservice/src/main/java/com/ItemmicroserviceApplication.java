package com;

import com.bean.Business;
import com.bean.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class ItemmicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemmicroserviceApplication.class, args);




    }

}
