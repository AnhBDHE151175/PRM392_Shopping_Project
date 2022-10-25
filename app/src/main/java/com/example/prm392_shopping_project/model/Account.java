package com.example.prm392_shopping_project.model;

public class Account {
    private String phone;
    private int password;

    public Account() {

    }

    public Account(String phone,int password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
