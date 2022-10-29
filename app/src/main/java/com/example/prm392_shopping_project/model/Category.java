package com.example.prm392_shopping_project.model;

import java.util.List;

public class Category {

    private int id;
    private String name;
    private int imageUrl;

    private List<Product> products;
    private Category(){

    }
    public Category(int id, String name, int imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
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

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {}
}
