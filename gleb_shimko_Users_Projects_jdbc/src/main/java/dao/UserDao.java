package dao;

import entity.User;

public interface UserDao{
    void save(User user);
    void getById(long id);
}
