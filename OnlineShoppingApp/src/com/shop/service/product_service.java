package com.shop.service;

import com.shop.entity.product;
import java.util.*;

public class product_service {
    private List<product> products = new ArrayList<>();

    public void addproduct(product p) { products.add(p); }
    public void removeProduct(int productId) { products.removeIf(p -> p.getProductId() == productId); }
    public List<product> getAllProducts() { return products; }
    public product getproductById(int id) {
        return products.stream().filter(p -> p.getProductId() == id).findFirst().orElse(null);
    }
}
