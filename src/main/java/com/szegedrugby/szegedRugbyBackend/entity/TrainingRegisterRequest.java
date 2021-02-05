package com.szegedrugby.szegedRugbyBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class TrainingRegisterRequest {
    private String title;
    private String type;
    private Long planId;
    private List<TrainingExersiceConnectorRequest> trainingExerciseConnectorList;


    protected TrainingRegisterRequest (){};

    @Autowired
    public TrainingRegisterRequest(String title, String type, Long planId, List<TrainingExersiceConnectorRequest> trainingExerciseConnectorList) {
        this.title = title;
        this.type = type;
        this.planId = planId;

        this.trainingExerciseConnectorList = trainingExerciseConnectorList;

    }

    @Override
    public String toString() {
        return "TrainingRegisterRequest{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", planId=" + planId +
                ", trainingExerciseConnectorList=" + trainingExerciseConnectorList +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public List<TrainingExersiceConnectorRequest> getTrainingExerciseConnectorList() {
        return trainingExerciseConnectorList;
    }

    public void setTrainingExerciseConnectorList(List<TrainingExersiceConnectorRequest> trainingExerciseConnectorList) {
        this.trainingExerciseConnectorList = trainingExerciseConnectorList;
    }
}
