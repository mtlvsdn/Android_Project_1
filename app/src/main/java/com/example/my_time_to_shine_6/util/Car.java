package com.example.my_time_to_shine_6.util;

import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private int km;
    private int year;

    public Car(String name, int km, int year) {
        this.name = name;
        this.km = km;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", km=" + km +
                ", year=" + year +
                '}';
    }
}
