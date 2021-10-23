package com.example.gira.service;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.enums.ClassificationEnum;

public interface ClassificationService {
    boolean checkClassificationRepoIsEmpty();

    void saveClassification(Classification c);


    Classification findByName(String classification);
}
