package com.example.gira;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.enums.ClassificationEnum;
import com.example.gira.service.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Arrays;

@Component
public class DbInit implements CommandLineRunner {

    private final ClassificationService classificationService;

    public DbInit(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {

        boolean checkIfClassificationRepoIsEmpty = this.classificationService
                .checkClassificationRepoIsEmpty();

        ArrayDeque<String> description = new ArrayDeque<>();

        description.push("Many more features");
        description.push("Big support of the product");
        description.push("Interesting features about the product");
        description.push("Bugs are bad for developer");

        if (checkIfClassificationRepoIsEmpty) {
            Arrays.stream(ClassificationEnum.values())
                    .map(c -> {

                        Classification classification = new Classification();
                        classification.setClassificationName(ClassificationEnum.valueOf(c.name()))
                                .setDescription(description.pop());

                        return classification;
                    })
                    .forEach(this.classificationService::saveClassification);

        }

    }
}
