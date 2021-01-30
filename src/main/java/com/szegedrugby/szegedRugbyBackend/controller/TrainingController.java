package com.szegedrugby.szegedRugbyBackend.controller;

import com.szegedrugby.szegedRugbyBackend.entity.ExerciseEntity;
import com.szegedrugby.szegedRugbyBackend.entity.PlanEntity;
import com.szegedrugby.szegedRugbyBackend.entity.TrainingEntity;
import com.szegedrugby.szegedRugbyBackend.entity.TrainingRegisterRequest;
import com.szegedrugby.szegedRugbyBackend.exception.ExerciseAlreadyRegisteredException;
import com.szegedrugby.szegedRugbyBackend.exception.NoDataInTableException;
import com.szegedrugby.szegedRugbyBackend.exception.PlanAlreadyRegisteredException;
import com.szegedrugby.szegedRugbyBackend.exception.TrainingException;
import com.szegedrugby.szegedRugbyBackend.repository.PlanRepository;
import com.szegedrugby.szegedRugbyBackend.service.ExerciseService;
import com.szegedrugby.szegedRugbyBackend.service.PlansService;
import com.szegedrugby.szegedRugbyBackend.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("training")
public class TrainingController {

    private static final Logger log = LoggerFactory.getLogger(TrainingController.class);

    PlansService plansService;
    ExerciseService exerciseService;
    TrainingService trainingService;

    @Autowired
    public TrainingController(PlansService plansService, ExerciseService exerciseService) {
        this.plansService = plansService;
        this.exerciseService = exerciseService;
    }


    @PostMapping("/addPlan")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanEntity addPlan(@RequestParam(value = "title") String title) {
        log.info("Incoming addPlan request : {}", title);
        try {
            PlanEntity result = plansService.addNewPlan(title);
            log.info("The result is: {}", result);
            return result;
        } catch (TrainingException e) {
            log.error("Error when adding new plan: {}" + e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping("/plans/getAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<PlanEntity> getPlans() {
        log.info("Incoming call for all plans");
        List<PlanEntity> planEntityList = plansService.listAllPlans();
        log.info("Sended data: {}", planEntityList);
        return planEntityList;
    }


    @PostMapping("/exercices/addExercise")
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciseEntity addExercise(@RequestBody Test test) {
        log.info("Incoming addExercise request : {}", test);
        ExerciseEntity result = null;
        try {
            result = exerciseService.addNewExercise(test.getTitle(), test.getPath());
            return result;
        } catch (ExerciseAlreadyRegisteredException e) {
            log.error("Error when adding new exercise: {}" + e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping("exercises/getAll")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ExerciseEntity> getExercises() {
        log.info("Incoming getExercises request");
        List<ExerciseEntity> exerciseEntityList = null;
        try {
            exerciseEntityList = exerciseService.listAllExercises();
            log.info("Sended data: {}", exerciseEntityList);
            return exerciseEntityList;
        } catch (NoDataInTableException e) {
            throw new ResponseStatusException(e.getHttpStatus(),e.getMessage());
        }
    }

    @PostMapping("trainings/addTraining")
    @ResponseStatus(HttpStatus.CREATED)
        public TrainingEntity addTraining(@RequestBody TrainingRegisterRequest request){
        log.info("Incoming addTraining request : {}", request);
        TrainingEntity result = trainingService.addNewTraining(new TrainingEntity(request.getTitle(),request.getType()));
        return null;
    }

}

class Test {
    private String title;
    private String path;

    public Test(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
