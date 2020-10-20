package com.BugTracker.Bug.controller;

import com.BugTracker.Bug.Database.InvalidPassword;
import com.BugTracker.Bug.Database.Bug;
import com.BugTracker.Bug.Database.BugDAO;
import com.BugTracker.Bug.Database.User;
import com.BugTracker.Bug.Database.UserService;
import com.BugTracker.Bug.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BugDAO bugDAO;

    @Autowired
    UserSession userSession;

    @PostMapping("/register-form")
    public ModelAndView register(@RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("password-again") String password2) {
        ModelAndView modelAndView = new ModelAndView("register");
        if (!password.equals(password2)) {
            modelAndView.addObject("message", "Passwords must match!");
            return modelAndView;
        } else {
            try {
                userService.save(email, password);
            } catch (InvalidPassword invalidPassword) {
                String messageException = invalidPassword.getMessage();
                modelAndView.addObject("message", messageException);
                return modelAndView;
            }
        }
        return new ModelAndView("redirect:/index.html");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("login");
        List<User> userList = userService.findByEmail(email);
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
                userSession.setUserId(userFromDatabase.getId());
                modelAndView = new ModelAndView("redirect:/dashboard");
            }
        }
        return modelAndView;
    }

    //sa securizam un link ce trebuie protejat prin login (cu Post, nu Get!)
    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        List<Bug> bug = bugDAO.findAll();
        for (Bug b : bug) {
            b.setUrl("Bugs?id=" + b.getIdBugs());
        }
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("bug", bug);
        return modelAndView;
    }

}
