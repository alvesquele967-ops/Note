package chiku.liu.service.impl;

import chiku.liu.dao.UserDao;
import chiku.liu.dao.impl.UserDaoImplForMySQL;
import chiku.liu.dao.impl.UserDaoImplForOracle;
import chiku.liu.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void deleteUser(){
        userDao.deleteById();
    }

    public void savaUser(){}

}
