package com.jb.erebor.rest;

import com.jb.erebor.entity.Bug;
import com.jb.erebor.entity.Project;
import com.jb.erebor.helper.BugTransactionsContainer;
import com.jb.erebor.service.BugService;
import com.jb.erebor.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BugRestController {


    private BugService bugService;
    private ProjectService projectService;

    @Autowired
    public BugRestController(BugService theBugService, ProjectService theProjectService){
        bugService = theBugService;
        projectService = theProjectService;
    }

    @GetMapping("/bugs")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Bug> findAll(){
        return bugService.findAll();
    }

    @GetMapping("/bugs/{bugId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Bug getBug(@PathVariable int bugId){
        Bug theBug = bugService.findBugById(bugId);

        if(theBug == null){
            throw new RuntimeException("The bug id requested was not found. Bug id requested: " + bugId);
        }

        return theBug;
    }

    @GetMapping("/bugs/developer/{developerUsername}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Bug> getBugsFromDeveloper(@PathVariable String developerUsername){

        List<Bug> developerBugs = bugService.findBugsByDeveloper(developerUsername);

        return developerBugs;
    }

    @GetMapping("/bugs/bug_container/{bugId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public BugTransactionsContainer getBugAndBugTransactionsFromBugId(@PathVariable int bugId){

        BugTransactionsContainer theBugTransactionContainer = bugService.findTransactionsForBug(bugId);

        return theBugTransactionContainer;

    }



    @PostMapping("/bugs")
    @CrossOrigin(origins = "http://localhost:3000")
    public Bug saveNewBug(@RequestBody Bug theBug){

        //in case bug sent to the backend has an id number I set it to 0, so that hibernate will create the correct
        //next id number

        theBug.setBugId(0);

        bugService.save(theBug);

        return theBug;
    }

    @PutMapping("/bugs")
    @CrossOrigin(origins = "http://localhost:3000")
    public Bug updateBug(@RequestBody Bug theBug){

        //TODO Make field for title longer inmysql

        bugService.save(theBug);

        return theBug;

    }

    @DeleteMapping("/bugs/{bugId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String deleteBug(@PathVariable int bugId){

        Bug tempBug = bugService.findBugById(bugId);

        if(tempBug == null){
            throw new RuntimeException("Bug with id: " + bugId + "not found.");
        }

        bugService.deleteById(bugId);

        return "deleted bug with bug id:" + bugId;

    }


}
