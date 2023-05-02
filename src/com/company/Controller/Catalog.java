package com.company.Controller;

import com.company.Model.Customer;
import com.company.Model.OrderAndPurchase;
import com.company.Model.Product;

import java.util.List;
import java.util.Map;

public class Catalog {

    private Map<String, Product> products;
    private List<OrderAndPurchase> orders;
    private List<OrderAndPurchase> purchases;

    public Catalog(Customer customer){
        products = customer.getProducts();
        orders = customer.getOrders();
        purchases = customer.getPurchases();
    }

    public void save_product(String id, String name, double price){
        Product product = products.get(id);
        if(product == null){
            product = new Product(id,name,price);
            products.put(id,product);
        }else{
            product.setName(name);
            product.setPrice(price);
        }
    }


    public void purchase_product(String id, int quantity, double price){
        if(!products.containsKey(id)){
            System.out.println("First you have to save the product");
            return;
        }
        Product product = products.get(id);
        product.setBalance(product.getBalance() + quantity);
        product.setTotal(product.getTotal() + price*quantity);
        OrderAndPurchase purchase = new OrderAndPurchase(id,quantity,quantity*price);
        purchases.add(purchase);
    }


    public void order_product(String id, int quantity){
        if(!products.containsKey(id)) return;
        Product product = products.get(id);
        if(product.getBalance() < quantity) return;
        product.setBalance(product.getBalance() - quantity);
        OrderAndPurchase order = new OrderAndPurchase(product.getId(), quantity, quantity*product.getPrice());
        orders.add(order);
    }

    public double get_quantity_of_product(String id){
        Product product = products.get(id);
        if(product == null) return 0.0;
        return product.getBalance();
    }


    private double get_avg(String id, List<OrderAndPurchase> list){
        if(list.isEmpty()) return 0;
        List<OrderAndPurchase> tmp = list.stream().filter(o -> o.getProduct().equals(id)).toList();
        double sum = 0;
        double num = 0;
        for (OrderAndPurchase o : tmp) {
            sum += o.getTotal();
            num += o.getQuantity();
        }
        return sum/num;
    }
    public double get_average_price(String id){
        return get_avg(id,purchases);
    }


    public double get_product_profit(String id){
        double purchased = get_average_price(id);
        double sold = get_avg(id,orders);
        List<OrderAndPurchase> list = orders.stream().filter(o -> o.getProduct().equals(id)).toList();
        int q = 0;
        for (OrderAndPurchase o: list) {
            q += o.getQuantity();
        }
        return (sold - purchased)*q;
    }

    public String get_fewest_product(){
        if(products.isEmpty()){
            System.out.println("There are not any products");
            return "";
        }
        Product res = null;
        double min = Integer.MAX_VALUE;
        for(String p: products.keySet()){
            Product tmp = products.get(p);
            if(tmp.getBalance() < min){
                res = tmp;
                min = tmp.getBalance();
            }
        }
        assert res != null;
        return res.getName();
    }

    public String get_most_popular_product(){
        if(products.isEmpty()){
            System.out.println("There are not any products");
            return "";
        }
        Product res = null;
        double min = Integer.MIN_VALUE;
        for(String p: products.keySet()){
            Product tmp = products.get(p);
            if(tmp.getBalance() > min){
                res = tmp;
                min = tmp.getBalance();
            }
        }
        assert res != null;
        return res.getName();
    }
}
