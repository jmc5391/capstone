package com.fishbuddy.capstone.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int cost;

    private int gal;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    private String typeName;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getGal() {
        return gal;
    }

    public void setGal(int gal) {
        this.gal = gal;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
