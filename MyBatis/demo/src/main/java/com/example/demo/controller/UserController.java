package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/index")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/list")
    public List<User> getUserList() {
        return userService.findAll();
    }

    @PostMapping("/user/insert")
    public int insertUser(@RequestBody Map<String, Object> userMap) {
        return userService.insertUserData(userMap);
    }

    @PutMapping("/user/update/{id}")
    public int updateUser(@PathVariable int id , @RequestBody Map<String, Object> userMap) {
        userMap.put("id", id);
        return userService.updateUserData(userMap);
    }

    @DeleteMapping("/user/delete/{ids}")
    public int deleteUser(@PathVariable String ids) {
//        分割逗号得到一个字符构成的数组
        Integer[] idArr = Arrays.stream(ids.split(","))
//                静态类型转换
                .map(Integer::parseInt)
//                加入数据到数组，类型为Integer
                .toArray(Integer[]::new);
        return userService.deleteUserDate(idArr);
    }
}
