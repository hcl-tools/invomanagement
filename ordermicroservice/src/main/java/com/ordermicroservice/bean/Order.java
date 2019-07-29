package com.ordermicroservice.bean;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private List<Item> items;

    public Order() {}

    public Order(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
