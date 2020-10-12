package com.BugTracker.Bug.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void save(String email, String password) throws InvalidPassword {
        if (password.length() < 6) {
            throw new InvalidPassword("Password must be at least 8 char. long");
        }
        if (userDAO.findByEmail(email).size() > 0) {
            throw new InvalidPassword("Email already linked to an account");
        }
        userDAO.save(email, password);
    }

    public List<User> findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
}
