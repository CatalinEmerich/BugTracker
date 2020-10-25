package com.BugTracker.Bug.controller;

import com.BugTracker.Bug.Database.Project;
import com.BugTracker.Bug.Database.ProjectDAO;
import com.BugTracker.Bug.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("/myprojects")
    public ModelAndView myProjects() {
        /*Acelasi cod ca in dashboard, pentru a genera link per proiect, cu ID-ul proiectului*/
        List <Project> projects = projectDAO.findAll();
        for (Project  p : projects) {
            p.setUrl("projects?id=" + p.getIdProject());
        }
        ModelAndView modelAndView = new ModelAndView("myprojects");
        modelAndView.addObject("myprojects", projects);
        return modelAndView;
    }
}
