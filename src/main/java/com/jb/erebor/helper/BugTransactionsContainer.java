package com.jb.erebor.helper;

import com.jb.erebor.entity.Bug;
import com.jb.erebor.entity.BugTransaction;

import java.util.List;

public class BugTransactionsContainer {

    private Bug theBug;

    private List<BugTransaction> bugTransactionList;

    public BugTransactionsContainer(Bug theBug, List<BugTransaction> bugTransactionList) {
        this.theBug = theBug;
        this.bugTransactionList = bugTransactionList;
    }

    public Bug getTheBug() {
        return theBug;
    }

    public void setTheBug(Bug theBug) {
        this.theBug = theBug;
    }

    public List<BugTransaction> getBugTransactionList() {
        return bugTransactionList;
    }

    public void setBugTransactionList(List<BugTransaction> bugTransactionList) {
        this.bugTransactionList = bugTransactionList;
    }

    @Override
    public String toString() {
        return "BugTransactionsContainer{" +
                "theBug=" + theBug +
                ", bugTransactionList=" + bugTransactionList +
                '}';
    }
}
