package com.fishbuddy.capstone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;

@Entity
public class Tank {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int gallons;

    private int temp;

    private HashMap<Fish, Integer> fish = new HashMap<Fish, Integer>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGallons() {
        return gallons;
    }

    public void setGallons(int gallons) {
        this.gallons = gallons;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public HashMap<Fish, Integer> getFish() {
        return fish;
    }

    public void setFish(HashMap<Fish, Integer> fish) {
        this.fish = fish;
    }
}
