package com.example.demo.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String roles;
    private boolean active;

    public User(Long id, String email, String password, String roles, boolean active) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }
    public User(User p) {
        this.id = p.id;
        this.email = p.email;
        this.password = p.password;
        this.roles = p.roles;
        this.active = p.active;
    }

    public User() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
