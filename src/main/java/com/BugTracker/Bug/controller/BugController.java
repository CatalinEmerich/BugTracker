package com.BugTracker.Bug.controller;

import com.BugTracker.Bug.Database.Bug;
import com.BugTracker.Bug.Database.BugDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BugController {

    @Autowired
    BugDAO bugDAO;

    @GetMapping("/bugdetails")
    public ModelAndView bugDetails(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("bugdetails");

        Bug bugDetails = bugDAO.findById(id);
        modelAndView.addObject("bugdetails", bugDetails);

        return modelAndView;

        //nu vede modelul cand incerc sa-l accesez din Dashboard!
    }

    @GetMapping("/mybugs")
    public ModelAndView myBugs(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("mybugs");

        Bug myBugs = (Bug) bugDAO.findAll();
        modelAndView.addObject("mybugs", myBugs);

        return modelAndView;
    }
}
