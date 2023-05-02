package com.company.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String username;
    private final Map<String, Product> products;
    private final ArrayList<OrderAndPurchase> purchases;
    private final ArrayList<OrderAndPurchase> orders;


    public Customer(String username) {
        this.username = username;
        this.products = new HashMap<>();
        this.orders = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public ArrayList<OrderAndPurchase> getOrders() {
        return orders;
    }

    public ArrayList<OrderAndPurchase> getPurchases() {
        return purchases;
    }
}
