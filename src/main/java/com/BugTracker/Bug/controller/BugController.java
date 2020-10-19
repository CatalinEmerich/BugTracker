package com.BugTracker.Bug.controller;

import com.BugTracker.Bug.Database.Bug;
import com.BugTracker.Bug.Database.BugDAO;
import com.BugTracker.Bug.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BugController {

    @Autowired
    BugDAO bugDAO;

    @Autowired
    UserSession userSession;

    @PostMapping("/mybugs")

    //trebuie 'id' generic sau ex: idBugs cum e campul din baza de date definit???

    public ModelAndView bug(@RequestParam ("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView( "bug");
        Bug bug = bugDAO.findById(id);
        modelAndView.addObject("bug", bug);
        return modelAndView;
    }

    @PostMapping("/addbug")
    public ModelAndView addBug(@RequestParam("idBugs") Integer id) {
        userSession.addNewBug(id);
        return new ModelAndView("redirect:mybugs.html");
    }
}
