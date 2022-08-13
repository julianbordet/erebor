package com.jb.erebor.rest;

import com.jb.erebor.entity.Bug;
import com.jb.erebor.entity.BugTransaction;
import com.jb.erebor.helper.BugTransactionsContainer;
import com.jb.erebor.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/bugs/{bugId}")
    public Bug getBug(@PathVariable int bugId){
        Bug theBug = bugService.findBugById(bugId);

        if(theBug == null){
            throw new RuntimeException("The bug id requested was not found. Bug id requested: " + bugId);
        }

        return theBug;
    }

    @GetMapping("/bugs/developer/{developerUsername}")
    public List<Bug> getBugsFromDeveloper(@PathVariable String developerUsername){

        List<Bug> developerBugs = bugService.findBugsByDeveloper(developerUsername);

        return developerBugs;
    }

    @GetMapping("/bugs/getbugandtransactions/{bugId}")
    public BugTransactionsContainer getBugTransactionsFromBugId(@PathVariable int bugId){

        BugTransactionsContainer theBugTransactionContainer = bugService.findTransactionsForBug(bugId);

        return theBugTransactionContainer;

    }

    /*
    @GetMapping("/bugs/detail/{bugId}")
    public Bug getBugDetailWithTransactions(@PathVariable int bugId){



    }
    */






}
