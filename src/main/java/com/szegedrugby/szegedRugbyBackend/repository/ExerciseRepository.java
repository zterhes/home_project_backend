package com.szegedrugby.szegedRugbyBackend.repository;

import com.szegedrugby.szegedRugbyBackend.entity.ExerciseEntity;
import com.szegedrugby.szegedRugbyBackend.service.ExerciseService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends CrudRepository<ExerciseEntity,Long> {
    @Override
    List<ExerciseEntity>findAll();

    Optional<ExerciseService> findFirstByTitleIgnoreLowerCase(String exerciseTitle);
}
