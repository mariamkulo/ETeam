package com.company;

import com.company.Controller.Catalog;
import com.company.Model.Customer;

import java.util.*;

public class ReadConsole {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String,Customer> customers = new HashMap<>();
    private static Catalog catalog = null;

    public static void start() {
        System.out.println("Enter Your Username: ");
        String username = sc.nextLine();
        Customer customer = null;
        if(customers.containsKey(username)) {
            customer = customers.get(username);
        }else {
            customer = new Customer(username);
            customers.put(username, customer);
        }
        catalog = new Catalog(customer);
        while (true) {
            System.out.println("Enter Your Command");
            commandParser(sc.nextLine());
        }
    }

    public static void commandParser(String command) {
        command = command.strip();
        String[] cmdArgs = command.split(" ");
        switch (cmdArgs[0]) {
            case "save_product":
                if (cmdArgs.length != 4) {
                    System.out.println("Invalid save_product command format.");
                } else {
                    String productId = cmdArgs[1];
                    String productName = cmdArgs[2];
                    double price = Double.parseDouble(cmdArgs[3]);
                    catalog.save_product(productId, productName, price);
                }
                break;
            case "purchase_product":
                if (cmdArgs.length == 4) {
                    String productId = cmdArgs[1];
                    int quantity = Integer.parseInt(cmdArgs[2]);
                    double price = Double.parseDouble(cmdArgs[3]);
                    catalog.purchase_product(productId, quantity, price);
                } else {
                    System.out.println("Invalid purchase_product command format.");
                }
                break;
            case "order_product":
                if (cmdArgs.length == 3) {
                    String productId = cmdArgs[1];
                    int quantity = Integer.parseInt(cmdArgs[2]);
                    catalog.order_product(productId, quantity);
                } else {
                    System.out.println("Invalid order_product command format.");
                }
                break;
            case "get_quantity_of_product":
                if (cmdArgs.length == 2) {
                    String productId = cmdArgs[1];
                    System.out.println(catalog.get_quantity_of_product(productId));
                } else {
                    System.out.println("Invalid get_quantity_of_product command format.");
                }
                break;
            case "get_average_price":
                if (cmdArgs.length == 2) {
                    String productId = cmdArgs[1];
                    System.out.println(catalog.get_average_price(productId));
                } else {
                    System.out.println("Invalid get_average_price command format.");
                }
                break;
            case "get_product_profit":
                if (cmdArgs.length == 2) {
                    String productId = cmdArgs[1];
                    System.out.println(catalog.get_product_profit(productId));
                } else {
                    System.out.println("Invalid get_product_profit command format.");
                }
                break;
            case "get_fewest_product":
                if (cmdArgs.length == 1) {
                    System.out.println(catalog.get_fewest_product());
                } else {
                    System.out.println("Invalid get_fewest_product command format.");
                }
                break;
            case "get_most_popular_product":
                if (cmdArgs.length == 1) {
                    System.out.println(catalog.get_most_popular_product());
                } else {
                    System.out.println("Invalid get_most_popular_product command format.");
                }
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Invalid command.");
                break;
        }
    }
}
