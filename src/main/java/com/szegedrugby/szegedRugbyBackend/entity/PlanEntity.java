package com.szegedrugby.szegedRugbyBackend.entity;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity

public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    @OneToMany(mappedBy = "planEntity")
    private List<TrainingEntity> trainingEntityList;

    protected PlanEntity() {
    }

    public PlanEntity(String title) {
        this.title = title;
        this.trainingEntityList = new ArrayList<>();
    }

    public PlanEntity(String title, List<TrainingEntity> list) {
        this.title = title;
        this.trainingEntityList = list;
    }

    public void addNewTrainingToPlan(TrainingEntity trainingEntity) {
        trainingEntityList.add(trainingEntity);
    }

    @Override
    public String toString() {
        return "PlanEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", trainingEntityList=" + trainingEntityList +
                '}';
    }

    public List<TrainingEntity> getTrainingEntityList() {
        return trainingEntityList;
    }

    public void setTrainingEntityList(List<TrainingEntity> trainingEntityList) {
        this.trainingEntityList = trainingEntityList;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
