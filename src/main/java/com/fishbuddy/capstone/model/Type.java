package com.fishbuddy.capstone.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private boolean required;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private Set<Equipment> equipmentList;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
