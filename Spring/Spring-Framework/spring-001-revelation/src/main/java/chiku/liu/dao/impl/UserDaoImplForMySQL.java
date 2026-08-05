package chiku.liu.dao.impl;

import chiku.liu.dao.UserDao;

public class UserDaoImplForMySQL implements UserDao {

    @Override
    public void deleteById(){
        System.out.println("MySQL正在删除用户信息");
    }
}
