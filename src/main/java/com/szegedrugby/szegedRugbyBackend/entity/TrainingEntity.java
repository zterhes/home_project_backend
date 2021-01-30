package com.szegedrugby.szegedRugbyBackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public TrainingEntity(String title, String type) {
        this.title = title;
        if (type.equals("Tabata")) this.type = TrainingTypes.TABATA;
        else if(type.equalsIgnoreCase("Circuit"))this.type=TrainingTypes.CIRCUIT;
        else if(type.equalsIgnoreCase("Gym"))this.type=TrainingTypes.GYM;
        else if(type.equalsIgnoreCase("Aerob"))this.type=TrainingTypes.AEROB;
        else throw new InputMismatchException();
    }
}
