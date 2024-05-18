package com.ykeshtdar.dto;

import lombok.Getter;
import lombok.Setter;

//this class corresponding to "http://localhost:8080/communityEmail?city=<city>"
@Getter
@Setter
public class CommunityEmail {
    private String email;


    @Override
    public String toString() {
        return "CommunityEmail{" +
                "email='" + email + '\'' +
                '}';
    }
}
