package com.jb.erebor.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jb.erebor.entity.Project;
import com.jb.erebor.helper.JSONProject;
import com.jb.erebor.service.BugService;
import com.jb.erebor.service.ProjectService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/projects/{projectId}")
    public Project getProjectById(@PathVariable int projectId){

        Project theProject = projectService.findByProjectId(projectId);

        return theProject;

    }

    @PutMapping("/projects")
    public JSONProject updateProject(@RequestBody JSONProject theProject){

        System.out.println(theProject);

        //TODO deserialization fails
        /*
        projectService.save(theProject);

         */

        return theProject;

    }

    @DeleteMapping("/projects/{projectId}")
    public String deleteProject(@PathVariable int projectId){

        Project tempProject = projectService.findByProjectId(projectId);

        if(tempProject == null){
            throw new RuntimeException("Project with id: " + projectId + " was not found.");
        }

        projectService.deleteById(projectId);

        return "Deleted project id - " + projectId;
    }

}
