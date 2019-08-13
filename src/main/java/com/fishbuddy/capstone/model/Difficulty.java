package com.fishbuddy.capstone.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Difficulty {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String difficultyLevel;

    @OneToMany
    @JoinColumn(name = "difficulty_id")
    private List<Fish> fish = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<Fish> getFish() {
        return fish;
    }

    public String toString() {
        return getDifficultyLevel();
    }
}
