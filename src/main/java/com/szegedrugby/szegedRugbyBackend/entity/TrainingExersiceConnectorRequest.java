package com.szegedrugby.szegedRugbyBackend.entity;

import lombok.NoArgsConstructor;

public class TrainingExersiceConnectorRequest {
    private long exerciseId;
    private int repeats;
    private int workTime;
    private int restBetweenSets;
    private int restAfterRound;
    private boolean linkedToTheNextExercise;

    public TrainingExersiceConnectorRequest(){};

    public TrainingExersiceConnectorRequest(long exerciseId, int repeats, int workTime, int restBetweenSets, int restAfterRound, boolean linkedToTheNextExercise) {
        this.exerciseId = exerciseId;
        this.repeats = repeats;
        this.workTime = workTime;
        this.restBetweenSets = restBetweenSets;
        this.restAfterRound = restAfterRound;
        this.linkedToTheNextExercise = linkedToTheNextExercise;
    }

    @Override
    public String toString() {
        return "TrainingExersiceConnectorRequest{" +
                ", exerciseId=" + exerciseId +
                ", repeats=" + repeats +
                ", workTime=" + workTime +
                ", restBetweenSets=" + restBetweenSets +
                ", restAfterRound=" + restAfterRound +
                ", linkedToTheNextExercise=" + linkedToTheNextExercise +
                '}';
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
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
