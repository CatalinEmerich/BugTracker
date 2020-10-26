package com.BugTracker.Bug.controller;

import com.BugTracker.Bug.Database.Bug;
import com.BugTracker.Bug.Database.BugDAO;
import com.BugTracker.Bug.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BugController {

    @Autowired
    BugDAO bugDAO;

    @Autowired
    UserSession userSession;

    @GetMapping("/bugdetails")
    @RequestMapping(name = "/bugdetails", method = RequestMethod.GET)
    public ModelAndView bugDetails(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("bugdetails");

        Bug bugDetails = bugDAO.findById(id);
        modelAndView.addObject("bugdetails", bugDetails);
        return modelAndView;
    }

    @GetMapping("/mybugs")
    public ModelAndView myBugs() {
        List<Bug> bugs = bugDAO.findAll();
        for (Bug b : bugs) {
            b.setUrl("bugs?id=" + b.getIdBug());
        }
        ModelAndView modelAndView = new ModelAndView("mybugs");
        modelAndView.addObject("bugs", bugs);
        return modelAndView;
    }

    @GetMapping("/addbug")
    public ModelAndView addBug() {
        return new ModelAndView("addbug");
    }
}
