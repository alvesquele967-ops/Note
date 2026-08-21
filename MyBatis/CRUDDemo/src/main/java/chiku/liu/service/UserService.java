package chiku.liu.service;

import chiku.liu.pojo.User;

import java.util.List;

public interface UserService {

    void insert(User user);

    void deleteById(int id);

    void update(User user);

    List<User> selectAll();
}
