package com.szegedrugby.szegedRugbyBackend.service;

import com.szegedrugby.szegedRugbyBackend.entity.*;
import com.szegedrugby.szegedRugbyBackend.exception.NoDataInTableException;
import com.szegedrugby.szegedRugbyBackend.repository.TrainingExerciseConnectorRepository;
import com.szegedrugby.szegedRugbyBackend.repository.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TrainingService {
    Logger log = LoggerFactory.getLogger(TrainingService.class);

    TrainingRepository trainingRepository;
    TrainingExerciseConnectorRepository trainingExerciseConnectorRepository;
    PlansService plansService;
    ExerciseService exerciseService;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository, PlansService plansService, ExerciseService exerciseService, TrainingExerciseConnectorRepository trainingExerciseConnectorRepository) {
        this.trainingRepository = trainingRepository;
        this.plansService = plansService;
        this.exerciseService = exerciseService;
        this.trainingExerciseConnectorRepository = trainingExerciseConnectorRepository;
    }

    public TrainingEntity addNewTrainingEasyWay(TrainingEntity trainingEntity) {
        TrainingEntity result = trainingRepository.save(trainingEntity);
        log.info("The result of addTraining : {}", result);
        return result;
    }


    public String addNewTraining(TrainingRegisterRequest trainingRegisterRequest) {
        log.info("addNewTraining is called by this data: {}", trainingRegisterRequest);
        //TrainingEntity result = trainingRepository.save(trainingEntity);
        PlanEntity planEntity = null;
        try {
            planEntity = plansService.getPlanById(trainingRegisterRequest.getPlanId());
            log.info("PlanEntity: {}", planEntity);
            TrainingEntity trainingEntity = new TrainingEntity(trainingRegisterRequest.getTitle(), trainingRegisterRequest.getType(), planEntity);
            log.info("New TrainingEntity made: {}", trainingEntity);
            TrainingExerciseConnector connector;
            TrainingEntity trainingEntitySavingResult = trainingRepository.save(trainingEntity);
            log.info("The result of saving TrainingEntity: {}", trainingEntitySavingResult);
            for (int index = 0; index < trainingRegisterRequest.getTrainingExerciseConnectorList().size(); index++) {
                TrainingExersiceConnectorRequest listRequest = trainingRegisterRequest.getTrainingExerciseConnectorList().get(index);
                connector = new TrainingExerciseConnector(
                        trainingEntity,
                        exerciseService.findById(listRequest.getExerciseId()),
                        listRequest.getRepeats(),
                        listRequest.getWorkTime(),
                        listRequest.getRestBetweenSets(),
                        listRequest.getRestAfterRound(),
                        listRequest.isLinkedToTheNextExercise()
                );
                trainingExerciseConnectorRepository.save(connector);
                trainingEntity.addDataToTrainingExerciseConnectorList(connector);
                log.info("trainingEntity: {}", trainingEntity);
                log.info("connector: {}", connector);
            }
            log.info("Módosított TrainingEntity: {}", trainingEntity);
            return "created";
        } catch (NoDataInTableException e) {
            log.error("This plan not found");
            throw new ResponseStatusException(e.getHttpStatus());
        }
    }
}
