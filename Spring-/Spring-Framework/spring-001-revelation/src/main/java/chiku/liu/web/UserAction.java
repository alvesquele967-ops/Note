package chiku.liu.web;

import chiku.liu.service.UserService;
import chiku.liu.service.impl.UserServiceImpl;

//表示层
public class UserAction {

    private UserService userService;

    public void deleteRequest(){
        userService.deleteUser();
    }
}
