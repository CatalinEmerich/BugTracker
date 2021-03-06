package com.BugTracker.Bug.controller;

import com.BugTracker.Bug.Database.*;
import com.BugTracker.Bug.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    //sa securizam un link ce trebuie protejat prin login (cu Post, nu Get!)
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

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {

        List<Bug> bugs = bugDAO.findAll();
        for (Bug b : bugs) {
            b.setUrl("bugs?id=" + b.getIdBug());
        }
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("bugs", bugs);
        return modelAndView;
        //de imbunatatit aici: de afisat doar bug-urile per utilizator logat!
    }
}
