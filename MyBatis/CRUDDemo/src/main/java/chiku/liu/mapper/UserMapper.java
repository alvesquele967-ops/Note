package chiku.liu.mapper;

import chiku.liu.pojo.User;

import java.util.List;

public interface UserMapper {

    void insert(User user);

    void deleteById(int id);

    void update(User user);

    List<User> selectAll();
}
