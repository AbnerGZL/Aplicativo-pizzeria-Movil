package com.tecsup.loginapp.Models;

public class Pizza {
    private String name;
    private String description;
    private double price;
    private String quantity;
    private int imageResId;

    public Pizza(String name, String description, double price, String quantity, int imageResId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public int getImageResId() {
        return imageResId;
    }
}
