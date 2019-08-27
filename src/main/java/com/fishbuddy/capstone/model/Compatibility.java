package com.fishbuddy.capstone.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compatibility {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @OneToMany
    @JoinColumn(name = "compatibility_id")
    private List<Fish> fish = new ArrayList<>();

    public Compatibility(String name) {

        this.name = name;
    }

    public Compatibility() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getName();
    }

    public Boolean isCompatible(Compatibility aComp) {

        if(this.name.equals(aComp.name)) {
            return true;
        }

        return false;
    }
}
