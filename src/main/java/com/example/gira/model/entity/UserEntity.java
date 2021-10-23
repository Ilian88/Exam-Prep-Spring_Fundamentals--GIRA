package com.example.gira.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_entities")
public class UserEntity extends BaseEntity{

    private String username;

    private String password;

    private String email;

    public UserEntity() {
    }

    @Column(name = "username",unique = true)
    @Size(min = 3,max = 20)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "password")
    @Size(min = 3,max = 20)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "email",nullable = false)
    @Email
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }
}
