package com.BugTracker.Bug.controller;

import com.BugTracker.Bug.Database.ProjectDAO;
import com.BugTracker.Bug.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

    @Autowired
    ProjectDAO projectDAO;

    @Autowired
    UserSession userSession;

    @PostMapping("/addproject")
    public ModelAndView addProject(@RequestParam("idProject") Integer id) {
        userSession.addNewProject(id);
        return new ModelAndView("redirect:/myprojects.html");
    }
}
