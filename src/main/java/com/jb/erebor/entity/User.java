package com.jb.erebor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private int enabled;

    @ManyToMany
    @JoinTable(
            name="project_user",
            joinColumns = @JoinColumn(name="username"),
            inverseJoinColumns = @JoinColumn(name="project_id")
    )
    private List<Project> projects;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", projects=" + projects +
                '}';
    }
}
