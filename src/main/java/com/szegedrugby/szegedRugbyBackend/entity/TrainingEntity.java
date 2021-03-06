package com.szegedrugby.szegedRugbyBackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.bind.v2.TODO;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Entity
@JsonIgnoreProperties({"planEntity"})
public class TrainingEntity {

    enum TrainingTypes {
        TABATA,
        CIRCUIT,
        GYM,
        AEROB
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private TrainingTypes type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan", nullable = false)
    private PlanEntity planEntity;


    @JsonIgnore
    @OneToMany(mappedBy = "trainingEntity")
    List<TrainingExerciseConnector> trainingExerciseConnectorList;

    protected TrainingEntity() {
    }

    ;


    public TrainingEntity(String title, String type, PlanEntity planEntity) {
        this.title = title;
        if (type.equals("Tabata")) this.type = TrainingTypes.TABATA;
        else if (type.equalsIgnoreCase("Circuit")) this.type = TrainingTypes.CIRCUIT;
        else if (type.equalsIgnoreCase("Gym")) this.type = TrainingTypes.GYM;
        else if (type.equalsIgnoreCase("Aerob")) this.type = TrainingTypes.AEROB;
        else throw new InputMismatchException();
        this.planEntity = planEntity;
        this.trainingExerciseConnectorList = new ArrayList<>();
    }

    public void addDataToTrainingExerciseConnectorList(TrainingExerciseConnector trainingExerciseConnector) {
        trainingExerciseConnectorList.add(trainingExerciseConnector);
    }

    public void removeDataToTrainingExerciseConnectorList(TrainingExerciseConnector trainingExerciseConnector) {
        trainingExerciseConnectorList.remove(trainingExerciseConnector); // TODO: 03.02.21 hozzáadni megcsinálni, hogy lehessen törölni egy exercise-t a trainingből, ez hozzá a metódus
    }

    @Override
    public String toString() {
        return "TrainingEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(TrainingTypes type) {
        this.type = type;
    }

    public PlanEntity getPlanEntity() {
        return planEntity;
    }

    public void setPlanEntity(PlanEntity planEntity) {
        this.planEntity = planEntity;
    }

    public List<TrainingExerciseConnector> getTrainingExerciseConnectorList() {
        return trainingExerciseConnectorList;
    }

    public void setTrainingExerciseConnectorList(List<TrainingExerciseConnector> trainingExerciseConnectorList) {
        this.trainingExerciseConnectorList = trainingExerciseConnectorList;
    }

    public TrainingTypes getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals("Tabata")) this.type = TrainingTypes.TABATA;
        else if (type.equalsIgnoreCase("Circuit")) this.type = TrainingTypes.CIRCUIT;
        else if (type.equalsIgnoreCase("Gym")) this.type = TrainingTypes.GYM;
        else if (type.equalsIgnoreCase("Aerob")) this.type = TrainingTypes.AEROB;
        else throw new InputMismatchException();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
