package com.fishbuddy.capstone.model;

import com.fishbuddy.capstone.model.data.equipment.TypeDao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Tank {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int cost;

    private int gal;

    @ManyToOne
    private Equipment filter;

    @ManyToOne
    private Equipment heater;

    @ManyToOne
    private Equipment light;

    @ManyToOne
    private Equipment stand;

    @ManyToOne
    private Equipment glassTank;

    private HashMap<Fish, Integer> fish = new HashMap<Fish, Integer>();

    private ArrayList<Equipment> equipList = new ArrayList<Equipment>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Fish, Integer> getFish() {
        return fish;
    }

    public void setFish(HashMap<Fish, Integer> fish) {
        this.fish = fish;
    }

    public void addEquipment(Equipment aEquip) {

        equipList.add(aEquip);
    }

    public int getCost() {
        return cost;
    }

    public void setCost() {

        this.cost = this.filter.getCost() + this.glassTank.getCost() + this.heater.getCost() + this.light.getCost() + this.stand.getCost();
    }

    public int getGal() {
        return gal;
    }

    public void setGal(int gal) {
        this.gal = gal;
    }

    public ArrayList<Equipment> getEquipment() {
        return equipList;
    }

    public Equipment getFilter() {
        return filter;
    }

    public void setFilter(Equipment filter) {
        if(filter.getTypeName().equals("Filter")) {
            this.filter = filter;
        }
    }

    public Equipment getHeater() {
        return heater;
    }

    public void setHeater(Equipment heater) {
        if(heater.getTypeName().equals("Heater")) {
            this.heater = heater;
        }
    }

    public Equipment getLight() {
        return light;
    }

    public void setLight(Equipment light) {
        if(light.getTypeName().equals("Light")) {
            this.light = light;
        }
    }

    public Equipment getStand() {
        return stand;
    }

    public void setStand(Equipment stand) {
        if(stand.getTypeName().equals("Stand")) {
            this.stand = stand;
        }
    }

    public Equipment getGlassTank() {
        return glassTank;
    }

    public void setGlassTank(Equipment glassTank) {
        if(glassTank.getTypeName().equals("Tank")) {
            this.glassTank = glassTank;
        }
    }

    public Equipment findEquipment(Iterable<Equipment> equipmentList, String aType) {
        Equipment found = new Equipment();
        int bestDiff = 100;
        int thisDiff = 0;
        for(Equipment aEquip : equipmentList) {
            if(aEquip.getTypeName().equals(aType)) {
                thisDiff = aEquip.getGal() - this.getGal();
                if(thisDiff >= 0 && thisDiff < bestDiff) {
                    bestDiff = thisDiff;
                    found = aEquip;
                }
            }
        }
        return found;
    }
}
