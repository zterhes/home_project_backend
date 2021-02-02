package com.szegedrugby.szegedRugbyBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@JsonIgnoreProperties({"trainingEntity"})
public class TrainingExerciseConnector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    TrainingEntity trainingEntity;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    ExerciseEntity exerciseEntity;

    private int repeats;
    private int workTime;
    private int restBetweenSets;
    private int restAfterRound;
    private boolean linkedToTheNextExercise;

    protected TrainingExerciseConnector(){};

    public TrainingExerciseConnector(TrainingEntity trainingEntity, ExerciseEntity exerciseEntity, int repeats, int workTime, int restBetweenSets, int restAfterRound, boolean linkedToTheNextExercise) {
        this.trainingEntity = trainingEntity;
        this.exerciseEntity = exerciseEntity;
        this.repeats = repeats;
        this.workTime = workTime;
        this.restBetweenSets = restBetweenSets;
        this.restAfterRound = restAfterRound;
        this.linkedToTheNextExercise = linkedToTheNextExercise;
    }

    @Override
    public String toString() {
        return "TrainingExerciseConnector{" +
                "id=" + id +
                ", trainingEntity=" + trainingEntity +
                ", exerciseEntity=" + exerciseEntity +
                ", repeats=" + repeats +
                ", workTime=" + workTime +
                ", restBetweenSets=" + restBetweenSets +
                ", restAfterRound=" + restAfterRound +
                ", linkedToTheNextExercise=" + linkedToTheNextExercise +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrainingEntity getTrainingEntity() {
        return trainingEntity;
    }

    public void setTrainingEntity(TrainingEntity trainingEntity) {
        this.trainingEntity = trainingEntity;
    }

    public ExerciseEntity getExerciseEntity() {
        return exerciseEntity;
    }

    public void setExerciseEntity(ExerciseEntity exerciseEntity) {
        this.exerciseEntity = exerciseEntity;
    }

    public int getRepeats() {
        return repeats;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getRestBetweenSets() {
        return restBetweenSets;
    }

    public void setRestBetweenSets(int restBetweenSets) {
        this.restBetweenSets = restBetweenSets;
    }

    public int getRestAfterRound() {
        return restAfterRound;
    }

    public void setRestAfterRound(int restAfterRound) {
        this.restAfterRound = restAfterRound;
    }

    public boolean isLinkedToTheNextExercise() {
        return linkedToTheNextExercise;
    }

    public void setLinkedToTheNextExercise(boolean linkedToTheNextExercise) {
        this.linkedToTheNextExercise = linkedToTheNextExercise;
    }
}
