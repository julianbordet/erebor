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
    @CrossOrigin
    public List<Bug> findAll(){
        return bugService.findAll();
    }

    @GetMapping("/bugs/{bugId}")
    @CrossOrigin
    public Bug getBug(@PathVariable int bugId){
        Bug theBug = bugService.findBugById(bugId);

        if(theBug == null){
            throw new RuntimeException("The bug id requested was not found. Bug id requested: " + bugId);
        }

        return theBug;
    }

    @GetMapping("/bugs/developer/{developerUsername}")
    @CrossOrigin
    public List<Bug> getBugsFromDeveloper(@PathVariable String developerUsername){

        List<Bug> developerBugs = bugService.findBugsByDeveloper(developerUsername);

        return developerBugs;
    }

    @GetMapping("/bugs/bug_container/{bugId}")
    @CrossOrigin
    public BugTransactionsContainer getBugAndBugTransactionsFromBugId(@PathVariable int bugId){

        BugTransactionsContainer theBugTransactionContainer = bugService.findTransactionsForBug(bugId);

        return theBugTransactionContainer;

    }

    @PostMapping("/bugs")
    @CrossOrigin
    public Bug saveNewBug(@RequestBody Bug theBug){

        //in case bug sent to the backend has an id number I set it to 0, so that hibernate will create the correct
        //next id number

        theBug.setBugId(0);

        bugService.save(theBug);

        return theBug;
    }

    @PutMapping("/bugs")
    @CrossOrigin
    public Bug updateBug(@RequestBody Bug updatedBug){

        //Compare bugs and create bugTransaction
        //Bug originalBug = bugService.findBugById(updatedBug.getBugId());
        Bug originalBug = new Bug();
        originalBug.setTitle(bugService.findBugById(updatedBug.getBugId()).getTitle());
        originalBug.setAssignedTo(bugService.findBugById(updatedBug.getBugId()).getAssignedTo());
        originalBug.setCreatedBy(bugService.findBugById(updatedBug.getBugId()).getCreatedBy());
        originalBug.setDescription(bugService.findBugById(updatedBug.getBugId()).getDescription());
        originalBug.setPriority(bugService.findBugById(updatedBug.getBugId()).getPriority());
        originalBug.setSeverity(bugService.findBugById(updatedBug.getBugId()).getSeverity());
        originalBug.setDateFixed(bugService.findBugById(updatedBug.getBugId()).getDateFixed());
        originalBug.setIsFixed(bugService.findBugById(updatedBug.getBugId()).getIsFixed());
        originalBug.setDueDate(bugService.findBugById(updatedBug.getBugId()).getDueDate());
        originalBug.setProjectId(bugService.findBugById(updatedBug.getBugId()).getProjectId());
        originalBug.setStepsToReproduce(bugService.findBugById(updatedBug.getBugId()).getStepsToReproduce());



        bugService.compareBugsAndCreateTransaction(updatedBug, originalBug);


        //update bug
        bugService.merge(updatedBug);

        return updatedBug;
    }

    @DeleteMapping("/bugs/{bugId}")
    @CrossOrigin
    public String deleteBug(@PathVariable int bugId){

        Bug tempBug = bugService.findBugById(bugId);

        if(tempBug == null){
            throw new RuntimeException("Bug with id: " + bugId + "not found.");
        }

        bugService.deleteById(bugId);

        return "deleted bug with bug id:" + bugId;

    }

}
