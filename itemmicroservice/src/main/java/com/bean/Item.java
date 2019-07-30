package com.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String category;
    private double sell;
    private double buy;
    private int stockCount;
    private Business provider;

    public Item() {
    }

    public Item(String title, String category, double sell, double buy, int stockCount, Business provider) {
        this.title = title;
        this.category = category;
        this.sell = sell;
        this.buy = buy;
        this.stockCount = stockCount;
        this.provider = provider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public Business getProvider() {
        return provider;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", sell=" + sell +
                ", buy=" + buy +
                ", stockCount=" + stockCount +
                ", provider=" + provider +
                '}';
    }
}
