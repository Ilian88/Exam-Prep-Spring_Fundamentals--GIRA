package com.example.gira.model.entity;

import com.example.gira.model.enums.ProgressEnum;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    private String name;

    private String description;

    private ProgressEnum progress;

    private LocalDate dueDate;

    private Classification classification;

    private UserEntity user;

    public Task() {
    }

    @Column(name = "name",unique = true)
    @Size(min = 3,max = 20)
    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description")
    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "progress")
    @Enumerated(EnumType.STRING)
    public ProgressEnum getProgress() {
        return progress;
    }

    public Task setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    @Column(name = "local_date")
    @FutureOrPresent
    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }


    @ManyToOne
    @NotNull
    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public Task setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
