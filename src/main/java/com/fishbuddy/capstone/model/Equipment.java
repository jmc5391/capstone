package com.fishbuddy.capstone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private int id;

    private int cost;
}
