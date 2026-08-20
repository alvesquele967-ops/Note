package chiku.liu.service;

import chiku.liu.pojo.User;

public interface UserService {

    void insert(User user);

    void deleteById(int id);
}
