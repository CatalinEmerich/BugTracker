package com.BugTracker.Bug.Database;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BugRowMapper implements RowMapper<Bug> {
    @Override
    public Bug mapRow (ResultSet resultSet, int i) throws SQLException {
        Bug bug = new Bug();
        bug.setIdBugs(resultSet.getInt( "idBug"));
        bug.setBugName(resultSet.getString("bugName"));
        bug.setBugNumber(resultSet.getInt("bugNumber"));
        bug.setBugDescription(resultSet.getString("bugDescription"));
        return bug;
    }
}
