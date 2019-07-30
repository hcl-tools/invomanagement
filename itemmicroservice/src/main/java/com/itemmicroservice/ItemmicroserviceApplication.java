package com.itemmicroservice;

import com.bean.Business;
import com.bean.Item;
import com.dao.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

        Business business1 = new Business("coles", "ivanhoe");
        Business business2 = new Business("coles", "heidelberg");
        Business business3 = new Business("coles", "bundoora");
        Business business4 = new Business("woolworths", "ivanhoe");
        Business business = new Business("green farms", "mildura");
        Business business5 = new Business("bidvest", "sydney");

        Item item1 = new Item("lettuce", "fruit and vegetables", 2.50, 1.50, 5, business);
        Item item2 = new Item("tomato", "fruit and vegetables", 0.50, 0.25, 10, business);
        Item item3 = new Item("apple", "fruit and vegetables", 0.50, 0.25, 15, business);
        Item item4 = new Item("toothpaste", "personal care", 5.50, 10.00, 100, business5);
        Item item5 = new Item("roast chicken", "meat", 10.00, 12.50, 20, business1);
        Item item6 = new Item("toothpaste", "personal care", 5.00, 7.50, 50, business2);
        Item item7 = new Item("samboy chips", "snacks", 2.50, 1.50, 30, business3);
        Item item8 = new Item("meredith goats cheese", "cheese", 7.00, 4.00, 10, business4);

        List<Item> itemsList = new ArrayList<>();
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);
        itemsList.add(item5);
        itemsList.add(item6);
        itemsList.add(item7);
        itemsList.add(item8);





    }

}
