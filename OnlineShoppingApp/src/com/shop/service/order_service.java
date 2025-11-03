package com.shop.service;

import com.shop.entity.*;
import java.util.*;

public class order_service {
    private List<order> orders = new ArrayList<>();

    public void placeorder(customer customer) {
        Map<product, Integer> items = new HashMap<>(customer.getCart().getItems());

        // Update stock quantities
        for (Map.Entry<product, Integer> entry : items.entrySet()) {
            product p = entry.getKey();
            int qty = entry.getValue();
            p.setStockQuantity(p.getStockQuantity() - qty);
        }

        order order = new order(customer, items);
        orders.add(order);
        customer.addorder(order);
        customer.getCart().clearCart();
    }

    public void updateOrderStatus(int orderId, String newStatus) {
        for (order o : orders) {
            if (o.getOrderId() == orderId) {
                o.setStatus(newStatus);
                break;
            }
        }
    }

    public List<order> getAllOrders() {
        return orders;
    }
}