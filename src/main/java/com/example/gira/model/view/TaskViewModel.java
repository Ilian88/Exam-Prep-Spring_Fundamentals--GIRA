package com.example.gira.model.view;

import java.time.LocalDate;

public class TaskViewModel {

    private String name;

    private String description;

    private String progress;

    private LocalDate dueDate;

    private String classification;

    private String user;

    public TaskViewModel() {
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(String progress) {
        this.progress = progress;
        return this;
    }



    public String getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(String classification) {
        this.classification = classification;
        return this;
    }

    public String getUser() {
        return user;
    }

    public TaskViewModel setUser(String user) {
        this.user = user;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
