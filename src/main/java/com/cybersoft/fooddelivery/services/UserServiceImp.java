package com.cybersoft.fooddelivery.services;

import com.cybersoft.fooddelivery.entity.Users;
import com.cybersoft.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Map<?,Object>> getUsers() {
        return userRepository.getRoleUser();
    }

    @Override
    public List<Users> getUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Users> getUsersByEmailAndPassword(String email, String password) {
        return userRepository.getUserByEmailPassword(email,password);
    }
}
