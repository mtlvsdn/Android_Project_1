package com.example.my_time_to_shine_6.util;

import java.io.Serializable;

public class Settings implements Serializable {
    String writeSomething;
    String city;

    public Settings(String writeSomething, String city) {
        this.writeSomething = writeSomething;
        this.city = city;
    }

    public String getWriteSomething() {
        return writeSomething;
    }

    public void setWriteSomething(String writeSomething) {
        this.writeSomething = writeSomething;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "writeSomething='" + writeSomething + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
