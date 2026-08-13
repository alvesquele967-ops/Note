package chiku.liu.dao.impl;

import chiku.liu.dao.UserDao;

public class UserDaoImplForOracle implements UserDao {

    @Override
    public void deleteById(){
        System.out.println("Oracle正在删除用户信息");
    }
}
