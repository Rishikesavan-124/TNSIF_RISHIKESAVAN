package com.shop.entity;

import java.util.HashMap;
import java.util.Map;

public class shoppingcart {
    private Map<product, Integer> items = new HashMap<>();

    public void addItem(product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }
   
    public Map<product, Integer> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }
}
