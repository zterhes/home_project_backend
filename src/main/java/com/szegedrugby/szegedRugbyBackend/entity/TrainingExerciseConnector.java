package com.szegedrugby.szegedRugbyBackend.entity;

import lombok.*;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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



}
