package com.BugTracker.Bug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/register-form")
    public ModelAndView register(@RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("password-again") String password2) {
        ModelAndView modelAndView = new ModelAndView("register");
        if (!password.equals(password2)) {
            modelAndView.addObject("message", "Passwords must match!");
        } else {
            jdbcTemplate.update("insert into users values (null, ?, ?)", email, password);
        }
        return new ModelAndView("redirect:/index.html");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView("login");
        List<User> userList = jdbcTemplate.query("select * from users where email='" + email + "';", new UserRowMapper());
        if (userList.size() == 0) ;
        {
            modelAndView.addObject("message", "Email and/or password incorrect!");
        }
        if (userList.size() > 1) {
            modelAndView.addObject("message", "Email and/or password incorrect!");
        }
        if (userList.size() == 1) {
            User userFromDatabase = userList.get(0);
            if (!userFromDatabase.getPassword().equals(password)) {
                modelAndView.addObject("message", "Email and/or password incorrect!");
            } else {
                modelAndView = new ModelAndView("redirect:/dashboard");
            }
        }
        return modelAndView;
    }

    //asa schimbam URL-ul afisat de browser:
    @GetMapping("dashboard")
    public ModelAndView dashboard() {
        return new ModelAndView("dashboard");
    }
}
