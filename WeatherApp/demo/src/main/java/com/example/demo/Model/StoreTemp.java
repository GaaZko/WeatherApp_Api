package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StoreTemp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String temperature;
    private Integer temperature2;

    public StoreTemp() {
    }


    public StoreTemp(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }


    /*
    public StoreTemp(Integer temperature2) {
        this.temperature2 = temperature2;
    }

    public Integer getTemperature2() {
        return temperature2;
    }

     */

    public Long getId() {
        return id;
    }


}
