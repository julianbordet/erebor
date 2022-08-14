package com.jb.erebor.rest;

import com.jb.erebor.entity.Project;
import com.jb.erebor.entity.User;
import com.jb.erebor.service.BugService;
import com.jb.erebor.service.ProjectService;
import com.jb.erebor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private BugService bugService;
    private ProjectService projectService;

    private UserService userService;

    @Autowired
    public UserRestController(BugService theBugService, ProjectService theProjectService, UserService theUserService){
        bugService = theBugService;
        projectService = theProjectService;
        userService = theUserService;
    }

    @GetMapping("/developers")
    public List<User> findAll(){

        return userService.findAll();

    }



}
