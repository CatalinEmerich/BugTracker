package com.BugTracker.Bug.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BugDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //folosim metoda Java 'findAll' prin care interogam baza de date pentru Bug-uri inregistrate
    public List<Bug> findAll() {
        return jdbcTemplate.query("select * from Bugs", new BugRowMapper());
    }

    public Bug findById (Integer id) {
        return jdbcTemplate.query("select * from Bugs where idBugs = " + id, new BugRowMapper()).get(0);
    }
}
