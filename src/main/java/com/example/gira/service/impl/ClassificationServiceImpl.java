package com.example.gira.service.impl;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.enums.ClassificationEnum;
import com.example.gira.repository.ClassificationRepository;
import com.example.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public boolean checkClassificationRepoIsEmpty() {
        return this.classificationRepository.count() == 0;
    }

    @Override
    public void saveClassification(Classification c) {
        this.classificationRepository.save(c);
    }

    @Override
    public Classification findByName(String classification) {
        return this.classificationRepository.findByClassificationName(
                ClassificationEnum.valueOf(classification)
        );
    }
}
