package com.fishbuddy.capstone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Tank {

    @Id
    @GeneratedValue
    private int id;

    private int gallons;

    private int temp;


}
