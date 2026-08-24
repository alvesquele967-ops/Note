package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insertUserData(Map<String, Object> userMap);
    int upUserDate(Map<String, Object> userMap);
    List<User> findAll();
    int deleteUser(Integer[] id);
}
