package com.BugTracker.Bug.controller;

import com.BugTracker.Bug.Database.Project;
import com.BugTracker.Bug.Database.ProjectDAO;
import com.BugTracker.Bug.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class ProjectController {

    @Autowired
    ProjectDAO projectDAO;

    @Autowired
    UserSession userSession;

    @GetMapping("/myprojects")
    public ModelAndView project(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("myprojects");

        Project project = projectDAO.findById(id);
        modelAndView.addObject("project", project);
        return modelAndView;
    }

    @PostMapping("/addproject")
    public ModelAndView addProject(@RequestParam("idProject") Integer id) {
        userSession.addNewProject(id);
        return new ModelAndView("redirect:myprojects.html");
    }
}
