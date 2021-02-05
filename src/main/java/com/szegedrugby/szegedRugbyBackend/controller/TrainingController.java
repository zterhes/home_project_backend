package com.szegedrugby.szegedRugbyBackend.controller;

import com.szegedrugby.szegedRugbyBackend.entity.*;
import com.szegedrugby.szegedRugbyBackend.exception.ExerciseAlreadyRegisteredException;
import com.szegedrugby.szegedRugbyBackend.exception.NoDataInTableException;
import com.szegedrugby.szegedRugbyBackend.exception.TrainingException;
import com.szegedrugby.szegedRugbyBackend.service.ExerciseService;
import com.szegedrugby.szegedRugbyBackend.service.PlansService;
import com.szegedrugby.szegedRugbyBackend.service.TrainingExerciseConnectorService;
import com.szegedrugby.szegedRugbyBackend.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("training")
public class TrainingController {

    private static final Logger log = LoggerFactory.getLogger(TrainingController.class);

    PlansService plansService;
    ExerciseService exerciseService;
    TrainingService trainingService;
    TrainingExerciseConnectorService trainingExerciseConnectorService;

    @Autowired
    public TrainingController(PlansService plansService, ExerciseService exerciseService, TrainingService trainingService, TrainingExerciseConnectorService trainingExerciseConnectorService) {
        this.plansService = plansService;
        this.exerciseService = exerciseService;
        this.trainingService = trainingService;
        this.trainingExerciseConnectorService = trainingExerciseConnectorService;
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
            log.error("Error when adding new plan: " + e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping("/plans/getAll")
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
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @GetMapping("job/getAllExercisesByTrainingId")
    public List<TrainingExerciseConnector> getExercisesByTrainingId(@RequestParam(value = "id")Long id){
        List<TrainingExerciseConnector> result= null;
        try {
            result = trainingExerciseConnectorService.findAllByTrainingId(id);
            log.info("result: {}",result);
            return result;
        } catch (NoDataInTableException e) {
            throw new ResponseStatusException(e.getHttpStatus(),e.getMessage());
        }
    }

    @PostMapping("trainings/addEasy")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingEntity addTraining(@RequestBody TrainingRegisterRequest request) {
        log.info("Incoming addTraining request : {}", request);
        try {
            PlanEntity planEntity = plansService.getPlanById(request.getPlanId());
            TrainingEntity result = trainingService.addNewTrainingEasyWay(new TrainingEntity(request.getTitle(), request.getType(), planEntity));
            return result;
        } catch (NoDataInTableException e) {
            log.info(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("trainings/add")
    public String addTrainingTest(@RequestBody TrainingRegisterRequest trainingRegisterRequest) {
        log.info("//////////////////////////////////////////new incoming request//////////////////////////////////////");
        log.info("Incoming addTrainingTest request : {}", trainingRegisterRequest);
        PlanEntity planEntity = null;
        try {
            planEntity = plansService.getPlanById(trainingRegisterRequest.getPlanId());
            log.info("PlanEntity: {}", planEntity);
            String result = trainingService.addNewTraining(trainingRegisterRequest);
            log.info("The result: {}", result);
            return result;
        } catch (NoDataInTableException e) {
            throw new ResponseStatusException(e.getHttpStatus());
        }
    }

}

class Test {
    private String title;
    private String path;

    protected Test (){};

    @Autowired
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
