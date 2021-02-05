package com.szegedrugby.szegedRugbyBackend.repository;

import com.szegedrugby.szegedRugbyBackend.entity.ExerciseEntity;
import com.szegedrugby.szegedRugbyBackend.entity.TrainingEntity;
import com.szegedrugby.szegedRugbyBackend.entity.TrainingExerciseConnector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingExerciseConnectorRepository extends CrudRepository<TrainingExerciseConnector,Long> {
    List<TrainingExerciseConnector> findAllByTrainingEntity(TrainingEntity trainingEntity);
}
