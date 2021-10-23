package com.example.gira.model.bindingModel;

import javax.validation.constraints.*;

public class AddTaskBindingModel {

    private String name;

    private String description;

    private String dueDate;

    private String classification;

    public AddTaskBindingModel() {
    }

    @Size(min = 3,max = 20,message = "Name must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public AddTaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 3,message = "Description must be at least 5 characters ")
    @NotNull(message = "Put description")
    public String getDescription() {
        return description;
    }

    public AddTaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }


    public String getDueDate() {
        return dueDate;
    }

    public AddTaskBindingModel setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }


    public String getClassification() {
        return classification;
    }

    public AddTaskBindingModel setClassification(String classification) {
        this.classification = classification;
        return this;
    }
}
