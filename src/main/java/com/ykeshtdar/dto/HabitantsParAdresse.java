package com.ykeshtdar.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
// this class corresponding to "http://localhost:8080/fire?address=<address>"
public class HabitantsParAdresse {
    private String firsName;
    private String phone;
    private int age;
    private List<String> medication;


    @Override
    public String toString() {
        return "HabitantsParAdresse{" +
                "firsName='" + firsName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", medication=" + medication +
                '}';
    }
}
