package com.szegedrugby.szegedRugbyBackend.repository;

import com.szegedrugby.szegedRugbyBackend.entity.TrainingEntity;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRepository extends CrudRepository<TrainingEntity,Long> {
}
