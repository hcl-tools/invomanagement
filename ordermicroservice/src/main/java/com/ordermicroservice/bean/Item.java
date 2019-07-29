package com.ordermicroservice.bean;

public class Item {

    private int id;
    private String title;
    private String category;
    private String tags;
    private double sell;
    private double buy;
    private int stockCount;
    private Business provider;

    public Item() {
    }

    public Item(int id, String title, String category, String tags, double sell, double buy, int stockCount, Busine provider) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.tags = tags;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public void setProvider(Business provider) {
        this.provider = provider;
    }
}
