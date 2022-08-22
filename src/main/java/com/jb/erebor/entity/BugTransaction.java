package com.jb.erebor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="bugtransactions")
public class BugTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private int transactionId;

    @Column(name="date")
    private String date;

    @Column(name="transaction_title")
    private String transactionTitle;

    @Column(name="transaction_detail")
    private String transactionDetail;

    @Column(name="created_by")
    private String createdBy;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    //@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="bug_id")
    //@JsonManagedReference
    @JsonBackReference
    private Bug bugId;

    public BugTransaction() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransactionTitle() {
        return transactionTitle;
    }

    public void setTransactionTitle(String transactionTitle) {
        this.transactionTitle = transactionTitle;
    }

    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Bug getBugId() {
        return bugId;
    }

    public void setBugId(Bug bugId) {
        this.bugId = bugId;
    }

    @Override
    public String toString() {
        return "BugTransaction{" +
                "transactionId=" + transactionId +
                ", date='" + date + '\'' +
                ", transactionTitle='" + transactionTitle + '\'' +
                ", transactionDetail='" + transactionDetail + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", bugId=" + bugId +
                '}';
    }
}
