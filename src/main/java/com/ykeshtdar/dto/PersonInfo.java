package com.ykeshtdar.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
//this url corresponding to "http://localhost:8080/personInfo?firstName=<firstName>&lastName=<lastName>"
public class PersonInfo {
    private String firstName;
    private String address;
    private int age;
    private String email;
    private List<String> medicationhistory;


    @Override
    public String toString() {
        return "PersonInfo{" +
                "firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", medicationhistory=" + medicationhistory +
                '}';
    }
}
