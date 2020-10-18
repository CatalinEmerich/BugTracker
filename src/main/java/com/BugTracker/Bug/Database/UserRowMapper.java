package com.BugTracker.Bug.Database;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow (ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt( "idLogin"));
        user.setEmail(resultSet.getString("Email"));
        user.setPassword(resultSet.getString("Password"));
        return user;
    }
}
