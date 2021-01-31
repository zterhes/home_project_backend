package com.szegedrugby.szegedRugbyBackend.entity;

import javax.persistence.*;
import java.util.InputMismatchException;

@Entity
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

    @ManyToOne
    @JoinColumn(name = "plan",nullable = false)
    private PlanEntity planEntity;

    protected TrainingEntity(){};

    public TrainingEntity(String title, String type, PlanEntity planEntity) {
        this.title = title;
        if (type.equals("Tabata")) this.type = TrainingTypes.TABATA;
        else if (type.equalsIgnoreCase("Circuit")) this.type = TrainingTypes.CIRCUIT;
        else if (type.equalsIgnoreCase("Gym")) this.type = TrainingTypes.GYM;
        else if (type.equalsIgnoreCase("Aerob")) this.type = TrainingTypes.AEROB;
        else throw new InputMismatchException();
        this.planEntity = planEntity;
    }

    @Override
    public String toString() {
        return "TrainingEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
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
