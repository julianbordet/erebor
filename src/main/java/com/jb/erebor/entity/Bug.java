package com.jb.erebor.entity;

import javax.persistence.*;

@Entity
@Table(name="bugs")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bug_id")
    private int bugId;

    @Column(name="project_id")
    private int projectId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="steps_to_reproduce")
    private String stepsToReproduce;

    @Column(name="severity")
    private String severity;

    @Column(name="priority")
    private String priority;

    @Column(name="date_created")
    private String dateCreated;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="assigned_to")
    private String assignedTo;

    @Column(name="due_date")
    private String dueDate;

    @Column(name="is_fixed")
    private int isFixed;

    @Column(name="date_fixed")
    private String dateFixed;


    public Bug() {
    }

    public Bug(int projectId, String title, String description, String stepsToReproduce,
               String severity, String priority, String dateCreated, String createdBy,
               String assignedTo, String dueDate, int isFixed, String dateFixed) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.stepsToReproduce = stepsToReproduce;
        this.severity = severity;
        this.priority = priority;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.isFixed = isFixed;
        this.dateFixed = dateFixed;
    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public void setStepsToReproduce(String stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(int isFixed) {
        this.isFixed = isFixed;
    }

    public String getDateFixed() {
        return dateFixed;
    }

    public void setDateFixed(String dateFixed) {
        this.dateFixed = dateFixed;
    }


    @Override
    public String toString() {
        return "Bug{" +
                "bugId=" + bugId +
                ", projectId=" + projectId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", stepsToReproduce='" + stepsToReproduce + '\'' +
                ", severity='" + severity + '\'' +
                ", priority='" + priority + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", isFixed=" + isFixed +
                ", dateFixed='" + dateFixed + '\'' +
                '}';
    }
}
