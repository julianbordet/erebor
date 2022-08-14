package com.jb.erebor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private int projectId;

    @Column(name="project_name")
    private String projectName;

    @Column(name="project_description")
    private String projectDescription;

    @Column(name="project_created_by")
    private String projectCreatedBy;

    @Column(name="project_current_owner")
    private String projectCurrentOwner;

    @Column(name="is_active")
    private int isActive;



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name="project_user",
            joinColumns = @JoinColumn(name="project_project_id"),
            inverseJoinColumns = @JoinColumn(name="user_username")
    )
    @JsonBackReference
    private List<User> users;




    public Project() {
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
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }



    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectCreatedBy='" + projectCreatedBy + '\'' +
                ", projectCurrentOwner='" + projectCurrentOwner + '\'' +
                ", isActive=" + isActive +
                ", users=" + users +
                '}';
    }


}
