package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

public class customer extends user {
    private String address;
    private shoppingcart cart;
    private List<order> orders;

    public customer(int userId, String username, String email, String address) {
        super(userId, username, email);
        this.address = address;
        this.cart = new shoppingcart();
        this.orders = new ArrayList<>();
    }

    public String getAddress() { return address; }
    public shoppingcart getCart() { return cart; }
    public List<order> getorders() { return orders; }

    public void addorder(order order) { orders.add(order); }

    @Override
    public String toString() {
        return super.toString() + ", Address: " + address;
    }
}

