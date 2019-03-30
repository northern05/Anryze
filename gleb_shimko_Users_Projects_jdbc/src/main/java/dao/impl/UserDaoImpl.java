package dao.impl;

import dao.UserDao;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao {

    Connection conn;

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(User user) {
//        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO users (email, phone, data_created) VALUES(?, ?, ?)")) {
//            ps.setString(1, user);
//            ps.setString(2, phone);
//            ps.setString(3, dateCreated);
//            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
//        }
    }

    @Override
    public void getById(long id) {

    }
}
