package com.szegedrugby.szegedRugbyBackend.repository;

import com.szegedrugby.szegedRugbyBackend.entity.TrainingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TrainingRepository extends CrudRepository<TrainingEntity,Long> {
    Optional<TrainingEntity> findFirstById(Long id);
}
