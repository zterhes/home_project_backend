package com.szegedrugby.szegedRugbyBackend.entity;

import javax.persistence.*;

@Entity
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String exercise_title;

    private String exercisePictureRoute;

    protected ExerciseEntity() {
    }

    ;

    public ExerciseEntity(String exercise_title, String exercisePictureRoute) {
        this.exercise_title = exercise_title;
        this.exercisePictureRoute = exercisePictureRoute;
    }

    @Override
    public String toString() {
        return "ExerciseEntity{" +
                "exercise_id=" + id +
                ", exercise_title='" + exercise_title + '\'' +
                ", exercisePictureRoute='" + exercisePictureRoute + '\'' +
                '}';
    }

    public Long getExercise_id() {
        return id;
    }

    public String getExercise_title() {
        return exercise_title;
    }

    public void setExercise_title(String exercise_title) {
        this.exercise_title = exercise_title;
    }

    public String getExercisePictureRoute() {
        return exercisePictureRoute;
    }

    public void setExercisePictureRoute(String exercisePictureRoute) {
        this.exercisePictureRoute = exercisePictureRoute;
    }
}
