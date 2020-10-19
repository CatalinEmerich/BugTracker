package com.BugTracker.Bug.Database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getInt("id"));
        project.setName(resultSet.getString("name"));
        project.setCode(resultSet.getInt("code"));
        project.setAssignedTo(resultSet.getString("assignedTo"));
        return project;
    }
}
