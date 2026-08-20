package chiku.liu.mapper;

import chiku.liu.pojo.User;

public interface UserMapper {

    void insert(User user);

    void deleteById(int id);
}
