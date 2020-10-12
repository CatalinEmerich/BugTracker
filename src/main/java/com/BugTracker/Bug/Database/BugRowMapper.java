package com.BugTracker.Bug.Database;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BugRowMapper implements RowMapper<Bug> {
    @Override
    public Bug mapRow (ResultSet resultSet, int i) throws SQLException {
        Bug bug = new Bug();
        bug.setId(resultSet.getInt( "id"));
        bug.setName(resultSet.getString("name"));
        bug.setNumber(resultSet.getInt("number"));
        bug.setDescription(resultSet.getString("description"));
        return bug;
    }
}
