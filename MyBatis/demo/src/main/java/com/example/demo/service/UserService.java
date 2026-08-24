package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();
    int insertUserData(Map<String, Object> userMap);
    int updateUserData(Map<String, Object> userMap);
    int deleteUserDate(Integer[] id);
}
