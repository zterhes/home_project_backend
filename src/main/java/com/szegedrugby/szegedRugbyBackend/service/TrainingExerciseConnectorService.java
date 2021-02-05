package com.szegedrugby.szegedRugbyBackend.service;

import com.szegedrugby.szegedRugbyBackend.entity.TrainingEntity;
import com.szegedrugby.szegedRugbyBackend.entity.TrainingExerciseConnector;
import com.szegedrugby.szegedRugbyBackend.entity.TrainingExersiceConnectorRequest;
import com.szegedrugby.szegedRugbyBackend.exception.NoDataInTableException;
import com.szegedrugby.szegedRugbyBackend.repository.TrainingExerciseConnectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingExerciseConnectorService {
    Logger log = LoggerFactory.getLogger(TrainingExerciseConnectorService.class);

    TrainingExerciseConnectorRepository trainingExerciseConnectorRepository;
    TrainingService trainingService;

    @Autowired
    public TrainingExerciseConnectorService(TrainingExerciseConnectorRepository trainingExerciseConnectorRepository, TrainingService trainingService) {
        this.trainingExerciseConnectorRepository = trainingExerciseConnectorRepository;
        this.trainingService = trainingService;
    }

    public List<TrainingExerciseConnector> findAllByTrainingId(Long id) throws NoDataInTableException {
        log.info("called find all by id in TrainingExerciseConnectorService with this id: {}", id);
        TrainingEntity trainingEntity = trainingService.findById(id);
        List<TrainingExerciseConnector> result = trainingExerciseConnectorRepository.findAllByTrainingEntity(trainingEntity);
        log.info("Result in service: {}", result);
        return result;
    }
}
