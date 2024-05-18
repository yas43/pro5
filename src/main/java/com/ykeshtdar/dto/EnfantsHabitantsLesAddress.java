package com.ykeshtdar.dto;


import com.ykeshtdar.model.Person;
import lombok.Getter;
import lombok.Setter;


import java.util.*;

// this class corresponding to "http://localhost:8080/childAlert?address=<address>"
@Getter
@Setter
public class EnfantsHabitantsLesAddress {
    private String name;
    private String familyName;
    private int age;
    private List<Person> personList;


    @Override
    public String toString() {
        return "EnfantsHabitantsLesAddress{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", personList=" + personList +
                '}';
    }
}
