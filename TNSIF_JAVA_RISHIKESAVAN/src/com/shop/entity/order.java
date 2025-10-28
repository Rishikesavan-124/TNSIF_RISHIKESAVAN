package com.shop.entity;

import java.util.Map;

public class order {
    private static int idCounter = 1;
    private int orderId;
    private customer customer;
    private Map<product, Integer> products;
    private String status;

    public order(customer customer, Map<product, Integer> products) {
        this.orderId = idCounter++;
        this.customer = customer;
        this.products = products;
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public customer getCustomer() { return customer; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order ID: " + orderId + ", Customer: " + customer.getUsername() + ", Status: " + status + "\n");
        for (Map.Entry<product, Integer> entry : products.entrySet()) {
            sb.append("  Product: " + entry.getKey().getName() + ", Quantity: " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
