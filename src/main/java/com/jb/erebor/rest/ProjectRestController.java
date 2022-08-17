package com.jb.erebor.rest;



import com.jb.erebor.entity.Project;
import com.jb.erebor.service.BugService;
import com.jb.erebor.service.ProjectService;
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
    @CrossOrigin
    public List<Project> getAllProjects(){

        List<Project> projectList = projectService.findAll();

        return  projectList;
    }

    @GetMapping("/projects/{projectId}")
    @CrossOrigin
    public Project getProjectById(@PathVariable int projectId){

        Project theProject = projectService.findByProjectId(projectId);

        return theProject;

    }

    @PutMapping("/projects")
    @CrossOrigin
    public Project updateProject(@RequestBody Project theProject){

        System.out.println(theProject);


        return theProject;

    }

    @DeleteMapping("/projects/{projectId}")
    @CrossOrigin
    public String deleteProject(@PathVariable int projectId){

        Project tempProject = projectService.findByProjectId(projectId);

        if(tempProject == null){
            throw new RuntimeException("Project with id: " + projectId + " was not found.");
        }

        projectService.deleteById(projectId);

        return "Deleted project id - " + projectId;
    }

}
