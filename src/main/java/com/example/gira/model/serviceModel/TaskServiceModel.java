package com.example.gira.model.serviceModel;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskServiceModel {

    private String name;

    private String description;

    private String progress;

    private LocalDate dueDate;

    private String classification;

    private String user;

    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getProgress() {
        return progress;
    }

    public TaskServiceModel setProgress(String progress) {
        this.progress = progress;
        return this;
    }



    public String getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(String classification) {
        this.classification = classification;
        return this;
    }

    public String getUser() {
        return user;
    }

    public TaskServiceModel setUser(String user) {
        this.user = user;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
