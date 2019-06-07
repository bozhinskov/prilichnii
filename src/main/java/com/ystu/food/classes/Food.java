package com.ystu.food.classes;

public class Food {
    private long id;
    private String name;
    private String img;
    private double price;

    public Food(long id, String name, String img, double price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
