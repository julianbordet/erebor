package com.jb.erebor.service;

import com.jb.erebor.dao.BugDAO;
import com.jb.erebor.entity.Bug;
import com.jb.erebor.entity.BugTransaction;
import com.jb.erebor.helper.BugTransactionsContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BugServiceImpl implements  BugService{

    private BugDAO bugDAO;

    @Autowired
    private ProjectService projectService;

    @Autowired
    public BugServiceImpl(BugDAO theBugDAO){
        bugDAO = theBugDAO;
    }

    @Override
    @Transactional
    public List<Bug> findAll() {
        return bugDAO.findAll();
    }

    @Override
    @Transactional
    public Bug findBugById(int theId) {
        return bugDAO.findByBugId(theId);
    }

    @Override
    @Transactional
    public List<Bug> findBugsByDeveloper(String developerUsername) {
        return bugDAO.findBugsByDeveloper(developerUsername);
    }

    public BugTransactionsContainer findTransactionsForBug(int bugId){

        BugTransactionsContainer theBugTransactionContainer = new BugTransactionsContainer(bugDAO.findByBugId(bugId),
                bugDAO.findTransactionsForBug(bugId));

        return theBugTransactionContainer;
    }





    @Override
    @Transactional
    public void save(Bug theBug) {
        bugDAO.save(theBug);
    }

    @Override
    @Transactional
    public void merge(Bug theBug){
        bugDAO.merge(theBug);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        bugDAO.deleteById(theId);
    }

    @Override
    public void compareBugsAndCreateTransaction(Bug updatedBug, Bug originalBug) {

        //UserUtility userUtility = new UserUtility();

        String changesMade = "";
        String changesMadeDetail = "";


        if ( !(updatedBug.getTitle().equals(originalBug.getTitle())) ){
            changesMade += "Title updated. ";
            changesMadeDetail += "Title updated from: " + originalBug.getTitle() + " to: " + updatedBug.getTitle();
            changesMadeDetail += "\n";
        }

        if ( !(updatedBug.getDescription().equals(originalBug.getDescription())) ){
            changesMade += "Description updated. ";
            changesMadeDetail += "Description updated: " + updatedBug.getDescription();
            changesMadeDetail += "\n";
        }


        if ( !(updatedBug.getProjectId() ==  originalBug.getProjectId() ) ){
            changesMade += "Assigned project changed. ";
            changesMadeDetail += "Project reassigned from: " +
                    projectService.findByProjectId(originalBug.getProjectId()).getProjectName() +
                    " to: " + projectService.findByProjectId(updatedBug.getProjectId()).getProjectName() +
                    "\n";
        }

        if ( !(updatedBug.getSeverity().equals(originalBug.getSeverity())) ){
            changesMade += "Severity updated. ";
            changesMadeDetail += "Bug severity updated from: " + originalBug.getSeverity() + " to: " +
                    updatedBug.getSeverity() +
                    "\n";
        }

        if ( !(updatedBug.getPriority().equals(originalBug.getPriority())) ){
            changesMade += "Priority updated. ";
            changesMadeDetail += "Priority updated from: " + originalBug.getPriority() + " to: " +
                    updatedBug.getPriority() +
                    "\n";
        }

        int updatedBugStatus = updatedBug.getIsFixed();
        int originalBugStatus = originalBug.getIsFixed();

        if ( !(updatedBugStatus ==  originalBugStatus) ){
            changesMade += "Status updated. ";

            if(updatedBugStatus == 1) {
                changesMadeDetail += "Status updated from: In Progress to Fixed\n";
            } else {
                changesMadeDetail += "Status updated from: Fixed to In Progress\n";
            }
        }

        if ( !(updatedBug.getAssignedTo().equals(originalBug.getAssignedTo())) ){
            changesMade += "Responsible dev changed. ";
            changesMadeDetail += "Responsible dev changed from: " + originalBug.getAssignedTo() + " to: " + updatedBug.getAssignedTo() +
                    "\n";
        }

        if ( !(updatedBug.getDueDate().equals(originalBug.getDueDate())) ){
            changesMade += "Due date updated. ";
            changesMadeDetail += "Due date updated from: " + originalBug.getDueDate() + " to: " + updatedBug.getDueDate() +
                    "\n";
        }

        if ( !(updatedBug.getStepsToReproduce().equals(originalBug.getStepsToReproduce())) ){
            changesMade += "Steps to reproduce updated. ";
            changesMadeDetail += "Steps to reproduce updated: " + updatedBug.getStepsToReproduce();
        }


        //Create a new date for the bug transaction
        Date today = new Date();
        String todayInString;
        todayInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(today);


        //check if changesMade variable is empty
        if ( !(changesMade.isEmpty()) ){

            //If it's not empty create a new transaction and add it to the bug
            BugTransaction newBugTransaction = new BugTransaction();
            newBugTransaction.setDate(todayInString);
            newBugTransaction.setTransactionTitle(changesMade);
            newBugTransaction.setTransactionId(0);

            //newBugTransaction.setTransactionCreatedBy(userUtility.getMyUserName());
            //TODO update the line below to use the username currently logged in once log in functionality is in place
            newBugTransaction.setCreatedBy("jbdev");

            newBugTransaction.setTransactionDetail(changesMadeDetail);

            updatedBug.addBugTransaction(newBugTransaction);

        }

    }


    @Override
    @Transactional
    public void deleteTransactions(Bug theBug) {
        bugDAO.deleteTransactions(theBug);
    }
}
