package org.example.dao;

import org.example.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImple implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(1));
        user.setName(rs.getString(2));
        user.setEmail(rs.getString(3));
        user.setGender(rs.getString(4));
        user.setPassword(rs.getString(5));
        user.setCreated_at(rs.getTimestamp(6));
        return user;
    }
}
