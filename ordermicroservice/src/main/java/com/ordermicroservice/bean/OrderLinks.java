package com.ordermicroservice.bean;


import javax.persistence.*;

@Entity
@Table(name = "orderLinks")
public class OrderLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int itemId;
    private int orderId;
    private int amount;
    private double price;

    public OrderLinks() {
    }

    public OrderLinks(int id, int itemId, int orderId, int amount, double price) {
        this.id = id;
        this.itemId = itemId;
        this.orderId = orderId;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
