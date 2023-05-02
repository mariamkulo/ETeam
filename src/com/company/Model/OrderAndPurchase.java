package com.company.Model;

public class OrderAndPurchase {
    private String product;
    private double quantity;
    private double total;

    public OrderAndPurchase(String product, double quantity, double total) {
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
