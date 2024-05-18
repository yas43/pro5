package com.ykeshtdar.service;


import com.fasterxml.jackson.databind.*;

import com.ykeshtdar.reader.JsonReaderFile;
import org.springframework.stereotype.Service;


import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
@Service
public class HabitantsParAdressService {
    JsonReaderFile jsonReaderFile = new JsonReaderFile();

    public Map<String, List<String>> personaddress(String address) throws IOException {
        Map<String, List<String>> map = new HashMap<>();
        List<String> coveredpersonslist = new LinkedList<>();
        for (int i = 0; i < jsonReaderFile.JsonReaderFileFireStation().size(); i++) {
            if (jsonReaderFile.JsonReaderFileFireStation().path(i).path("address").asText().equals(address)) {
                for (int j = 0; j < jsonReaderFile.JsonReaderFilePerson().size(); j++) {
                    if (jsonReaderFile.JsonReaderFileFireStation().path(i).path("address").equals(jsonReaderFile.JsonReaderFilePerson().path(j).path("address"))) {
                        for (int k = 0; k < jsonReaderFile.JsonReaderFileMedicalRecords().size(); k++) {
                            if (jsonReaderFile.JsonReaderFileMedicalRecords().path(k).path("firstName").equals(jsonReaderFile.JsonReaderFilePerson().path(j).path("firstName"))) {
                                coveredpersonslist.add(jsonReaderFile.JsonReaderFilePerson().path(j).path("firstName").toString());
                                coveredpersonslist.add(jsonReaderFile.JsonReaderFilePerson().path(j).path("phone").toString());
                                coveredpersonslist.add(String.valueOf(age(jsonReaderFile.JsonReaderFileMedicalRecords().path(k))));
                                map.put(jsonReaderFile.JsonReaderFileFireStation().path(i).path("station").toString(),coveredpersonslist);


                            }
                        }
                    }
                }
            }

        }

        return map;
    }


    private int age(JsonNode jsonNode){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(jsonNode.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age;

    }

}
