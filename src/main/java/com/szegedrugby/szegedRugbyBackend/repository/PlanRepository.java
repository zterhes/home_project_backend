package com.szegedrugby.szegedRugbyBackend.repository;

import com.szegedrugby.szegedRugbyBackend.entity.PlanEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlanRepository  extends CrudRepository<PlanEntity,Long> {
    @Override
    List<PlanEntity>findAll();

    Optional<PlanEntity> findFirstByTitleIgnoreCase(String title);
}
