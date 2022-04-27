package org.example.dao;

import org.example.entities.User;

import java.util.List;

public interface UserDao {
    int insert(User user);
    int update(User user);
    int delete(int userId);
    User getUser(int userId);
    List<User> getUsers();
}
