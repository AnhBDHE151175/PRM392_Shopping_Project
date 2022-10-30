package com.example.prm392_shopping_project.model;

public class Cart {


    int id;
    String name;
    int price;
    String unit;
    int quantity;

    public Cart(int id, String name, int price, String unit, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Cart(String name, int price, String unit, int quantity) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
