package org.example.dao;

import org.example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("getUserDao")
public class UserImple implements UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public UserImple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(User user) {
        String sql = "insert into users(name,email,gender,password) values(?,?,?,?)";
        return this.jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getGender(), user.getPassword());
    }

    @Override
    public int update(User user) {
        String sql = "update users set name=?,email=?,gender=?,password=? where id=?";
        return this.jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getGender(), user.getPassword(), user.getId());
    }

    @Override
    public int delete(int userId) {
        String sql = "delete from users where id=?";
        return this.jdbcTemplate.update(sql, userId);
    }

    @Override
    public User getUser(int userId) {
        String sql = "select * from users where id=?";
        RowMapperImple rowMapper = new RowMapperImple();
        return this.jdbcTemplate.queryForObject(sql, rowMapper, userId);
    }

    @Override
    public List<User> getUsers() {
        String sql = "select * from users";
        return (List<User>) this.jdbcTemplate.query(sql,new RowMapperImple());
    }
}
