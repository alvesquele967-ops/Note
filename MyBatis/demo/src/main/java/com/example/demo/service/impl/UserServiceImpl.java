package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int insertUserData(Map<String, Object> userMap) {
        return userMapper.insertUserData(userMap);
    }

    @Override
    public int updateUserData(Map<String,Object> userMap){
        return userMapper.upUserDate(userMap);
    }

    @Override
    public int deleteUserDate(Integer[] id){
        return userMapper.deleteUser(id);
    }
}
