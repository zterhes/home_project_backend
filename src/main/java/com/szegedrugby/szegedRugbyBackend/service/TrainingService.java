package com.szegedrugby.szegedRugbyBackend.service;

import com.szegedrugby.szegedRugbyBackend.entity.TrainingEntity;
import com.szegedrugby.szegedRugbyBackend.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
    TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }


    public TrainingEntity addNewTraining(TrainingEntity trainingEntity) {
        TrainingEntity result=trainingRepository.save(trainingEntity);

    }
}
