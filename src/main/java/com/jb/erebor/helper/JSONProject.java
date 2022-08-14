package com.jb.erebor.helper;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jb.erebor.entity.User;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class JSONProject {

    private int projectId;

    private String projectName;

    private String projectDescription;

    private String projectCreatedBy;

    private String projectCurrentOwner;

    private int isActive;

    private List<User> userList;

    public JSONProject(){

    }

    public JSONProject(int projectId, String projectName, String projectDescription, String projectCreatedBy, String projectCurrentOwner, int isActive, List<User> users) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectCreatedBy = projectCreatedBy;
        this.projectCurrentOwner = projectCurrentOwner;
        this.isActive = isActive;
        this.userList = users;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectCreatedBy() {
        return projectCreatedBy;
    }

    public void setProjectCreatedBy(String projectCreatedBy) {
        this.projectCreatedBy = projectCreatedBy;
    }

    public String getProjectCurrentOwner() {
        return projectCurrentOwner;
    }

    public void setProjectCurrentOwner(String projectCurrentOwner) {
        this.projectCurrentOwner = projectCurrentOwner;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public List<User> getUsers() {
        return userList;
    }

    public void setUsers(List<User> users) {
        this.userList = users;
    }

    @Override
    public String toString() {
        return "JSONProject{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectCreatedBy='" + projectCreatedBy + '\'' +
                ", projectCurrentOwner='" + projectCurrentOwner + '\'' +
                ", isActive=" + isActive +
                ", users=" + userList +
                '}';
    }
}
