package com.cybersoft.fooddelivery.services;

import com.cybersoft.fooddelivery.entity.Users;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Map<?,Object>> getUsers();
    List<Users> getUsersByEmail(String email);

    List<Users> getUsersByEmailAndPassword(String email, String password);
}
