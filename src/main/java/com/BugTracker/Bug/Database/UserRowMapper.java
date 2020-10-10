package com.BugTracker.Bug.Database;

import com.BugTracker.Bug.Database.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow (ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt( "id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}