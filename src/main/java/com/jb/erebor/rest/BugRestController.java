package com.jb.erebor.rest;

import com.jb.erebor.entity.Bug;
import com.jb.erebor.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BugRestController {


    private BugService bugService;

    @Autowired
    public BugRestController(BugService theBugService){
        bugService = theBugService;
    }

    @GetMapping("/bugs")
    public List<Bug> findAll(){
        return bugService.findAll();
    }



}
