package com.szegedrugby.szegedRugbyBackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String exercisePictureRoute;

    @OneToMany(mappedBy = "exerciseEntity")
    List<TrainingExerciseConnector> trainingExerciseConnectorList;

    protected ExerciseEntity() {
    }

    public ExerciseEntity(String title, String exercisePictureRoute) {
        this.title = title;
        this.exercisePictureRoute = exercisePictureRoute;
    }

    @Override
    public String toString() {
        return "ExerciseEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", exercisePictureRoute='" + exercisePictureRoute + '\'' +
                '}';
    }

    public Long getExercise_id() {
        return id;
    }

    public String getExercise_title() {
        return title;
    }

    public void setExercise_title(String exercise_title) {
        this.title = exercise_title;
    }

    public String getExercisePictureRoute() {
        return exercisePictureRoute;
    }

    public void setExercisePictureRoute(String exercisePictureRoute) {
        this.exercisePictureRoute = exercisePictureRoute;
    }
}
