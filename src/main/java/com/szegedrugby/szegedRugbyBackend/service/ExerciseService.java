package com.szegedrugby.szegedRugbyBackend.service;

import com.szegedrugby.szegedRugbyBackend.entity.ExerciseEntity;
import com.szegedrugby.szegedRugbyBackend.exception.ExerciseAlreadyRegisteredException;
import com.szegedrugby.szegedRugbyBackend.repository.ExerciseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseService {
    Logger log = LoggerFactory.getLogger(ExerciseService.class);

    ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


    public ExerciseEntity addNewExercise(String exerciseTitle, String exercisePictureRoute) throws ExerciseAlreadyRegisteredException {
        Optional<ExerciseEntity> sameTitle = exerciseRepository.findFirstByTitleIgnoreCase(exerciseTitle);
        if (sameTitle.isPresent()) {
            log.error("This exerciseTitle already registered. Title: {}", exerciseTitle);
            throw new ExerciseAlreadyRegisteredException("This exerciseTitle already registered.");
        } else {
            log.info("The pic path: {}", exercisePictureRoute);
            ExerciseEntity result = exerciseRepository.save(new ExerciseEntity(exerciseTitle, exercisePictureRoute));
            log.info("Exercise saved : {}: ", result.toString());
            return result;
        }
    }
}
