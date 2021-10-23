package com.example.gira.model.entity;

import com.example.gira.model.enums.ClassificationEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity {

    private ClassificationEnum classificationName;

    private String description;

    public Classification() {
    }

    @Column(name = "classification_name")
    @Enumerated(EnumType.STRING)
    public ClassificationEnum getClassificationName() {
        return classificationName;
    }

    public Classification setClassificationName(ClassificationEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    @Column(name = "description",columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
