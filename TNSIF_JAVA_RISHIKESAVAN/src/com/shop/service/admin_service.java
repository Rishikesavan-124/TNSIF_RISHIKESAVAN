package com.shop.service;

import com.shop.entity.admin;
import java.util.*;

public class admin_service {
    private List<admin> admins = new ArrayList<>();

    public void addAdmin(admin a) { admins.add(a); }
    public List<admin> getAllAdmins() { return admins; }
}
