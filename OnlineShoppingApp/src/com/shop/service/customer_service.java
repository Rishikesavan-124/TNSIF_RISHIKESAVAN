package com.shop.service;

import com.shop.entity.customer;
import java.util.*;

public class customer_service {
    private List<customer> customers = new ArrayList<>();

    public void addcustomer(customer c) { customers.add(c); }
    public List<customer> getAllCustomers() { return customers; }
    public customer getcustomerById(int id) {
        return customers.stream().filter(c -> c.getUserId() == id).findFirst().orElse(null);
    }
}
