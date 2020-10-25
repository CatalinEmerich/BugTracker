package com.BugTracker.Bug.Database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Project project = new Project();
        project.setIdProject(resultSet.getInt("idProject"));
        project.setProjectName(resultSet.getString("Name"));
        project.setProjectCode(resultSet.getInt("Code"));
        project.setAssignedTo(resultSet.getString("AssignedTo"));
        project.setProjectDescription(resultSet.getString("Description"));
        return project;
    }
}
