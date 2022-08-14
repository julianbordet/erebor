package com.jb.erebor.rest;

import com.jb.erebor.entity.Project;
import com.jb.erebor.service.BugService;
import com.jb.erebor.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectRestController {

    private BugService bugService;
    private ProjectService projectService;

    @Autowired
    public ProjectRestController(BugService theBugService, ProjectService theProjectService){
        bugService = theBugService;
        projectService = theProjectService;
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects(){

        List<Project> projectList = projectService.findAll();

        return  projectList;
    }

}
