package com.ykeshtdar.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
//this url corresponding to "http://localhost:8080/flood/stations?stations=<a list of station_numbers>"
public class AdresseParCaserne {
    private String firstName;
    private String phone;
    private int age;
    private List<String> medicalbackgroundlist;


    @Override
    public String toString() {
        return "AdresseParCaserne{" +
                "firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", medicalbackgroundlist=" + medicalbackgroundlist +
                '}';
    }
}
