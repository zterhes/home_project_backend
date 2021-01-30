package com.szegedrugby.szegedRugbyBackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String exercisePictureRoute;

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
