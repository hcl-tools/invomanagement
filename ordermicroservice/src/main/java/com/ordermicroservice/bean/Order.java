package com.ordermicroservice.bean;

import org.springframework.data.annotation.Id;

//import javax.persistence.*;
import java.util.List;


//@Entity
//@Table(name = "order")
public class Order {


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderId;
//    @Transient
//    private List<Item> items;

    public Order() {}

    public Order(int id, int orderId) {
        this.id = id;
        this.orderId = orderId;
    }

    public Order(int id, int orderId, List<Item> items) {
        this.id = id;
        this.orderId = orderId;
//        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
}
