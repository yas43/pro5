package com.ykeshtdar.P5.service;


import com.ykeshtdar.P5.dto.*;
import com.ykeshtdar.P5.reader.*;

import java.io.*;
import java.util.*;

public class CommunityEmailServices {
    JsonReaderFile jsonReaderFile = new JsonReaderFile();
    List<CommunityEmail> communityEmailList = new LinkedList<>();
    public List<CommunityEmail> communityEmail(String city) throws IOException {
        for (int i=0;i<jsonReaderFile.JsonReaderFilePerson().size();i++){
            CommunityEmail communityEmail = new CommunityEmail();
            if (jsonReaderFile.JsonReaderFilePerson().path(i).path("city").asText().equalsIgnoreCase(city)){
                communityEmail.setEmail(jsonReaderFile.JsonReaderFilePerson().path(i).path("email").toString());
                communityEmailList.add(communityEmail);
            }
        }
        return communityEmailList;
    }
}
