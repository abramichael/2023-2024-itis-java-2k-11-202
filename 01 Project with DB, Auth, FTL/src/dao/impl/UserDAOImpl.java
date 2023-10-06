package com.example.votingsystem2.dao.impl;

import com.example.votingsystem2.JDBCConnection;
import com.example.votingsystem2.dao.DAO;
import com.example.votingsystem2.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements DAO<User> {

    @Override
    public void create(User u) {

    }

    @Override
    public User get(long id) {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from users where id = ?"
            );
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getString(2),
                        rs.getString(3)
                );
                return u;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public void update(User u) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> getAll() {
        try {
            PreparedStatement statement = JDBCConnection.getConn().prepareStatement(
                    "select * from users"
            );
            ResultSet rs = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User u = new User(
                        rs.getString(2),
                        rs.getString(3)
                );
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
