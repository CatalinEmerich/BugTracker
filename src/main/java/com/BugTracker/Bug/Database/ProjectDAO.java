package com.BugTracker.Bug.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Project> findAll() {
        return jdbcTemplate.query("select * from Projects", new ProjectRowMapper());
    }

    public Project findById(Integer id) {
        return jdbcTemplate.query("select * from Projects where id = " + id, new ProjectRowMapper()).get(0);
    }

    public void saveProject(String name, String description, int code) {
        jdbcTemplate.update("insert into Projects (idProject, Code, Name, AssignedTo) values (null, ?, ?, ?)",
                name, description, code, 1, null, null);
    }
}
