package com.ykeshtdar.dto;

import lombok.Getter;
import lombok.Setter;

// this class corresponding to "http://localhost:8080/phoneAlert?firestation=<firestation_number>"
@Getter
@Setter
public class NumerosTelephoneParCaserne {

    private String phoneNumber;



    @Override
    public String toString() {
        return "NumérosTéléphoneParCaserne{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
