package com.BugTracker.Bug.Database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Project project = new Project();
        project.setIdProject(resultSet.getInt("id"));
        project.setProjectName(resultSet.getString("name"));
        project.setProjectCode(resultSet.getInt("code"));
        project.setAssignedTo(resultSet.getString("assignedTo"));
        return project;
    }
}
