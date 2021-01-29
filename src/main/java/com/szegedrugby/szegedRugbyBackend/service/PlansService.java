package com.szegedrugby.szegedRugbyBackend.service;

import com.szegedrugby.szegedRugbyBackend.entity.PlanEntity;
import com.szegedrugby.szegedRugbyBackend.exception.PlanAlreadyRegisteredException;
import com.szegedrugby.szegedRugbyBackend.repository.PlanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlansService {
    Logger log = LoggerFactory.getLogger(PlansService.class);

    PlanRepository planRepository;

    @Autowired
    public PlansService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }


    public List<PlanEntity> listAllPlans() {
        log.info("called listPlans in PlansService");
        List<PlanEntity> planEntities = planRepository.findAll();
        log.info("listPlans result: {}", planEntities);
        return planEntities;
    }

    public PlanEntity addNewPlan(String title) throws PlanAlreadyRegisteredException {
        Optional<PlanEntity> sameTitle = planRepository.findFirstByTitleIgnoreCase(title);
        if (sameTitle.isPresent()) {
            log.error("This planTitle already registered. Title: {}", title);
            throw new PlanAlreadyRegisteredException("The plantitle already registered");
        } else {
            PlanEntity result = planRepository.save(new PlanEntity(title));
            log.info("Plan saved: {}",result.toString());
            return result;
        }
    }
}
