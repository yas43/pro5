package com.ykeshtdar.service;


import com.fasterxml.jackson.databind.*;


import com.ykeshtdar.dto.AdresseParCaserne;
import com.ykeshtdar.reader.JsonReaderFile;

import org.springframework.stereotype.*;


import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
@Service
public class AdressParCasernServices {
    JsonReaderFile jsonReaderFile = new JsonReaderFile();
    List<Integer> firestationnumberlist = new LinkedList<>();
    public List< Map<String, List<AdresseParCaserne>>> addresseesForFireStation(List<Integer> firestationnumberlist) throws IOException {
       List<Map<String,List<AdresseParCaserne>>> StationAddressList = new LinkedList<>();
       for (Integer firestationnumber:firestationnumberlist) {
           String firestationnumberstring = String.valueOf(firestationnumber);
           List<AdresseParCaserne> adresseParCaserneList = new LinkedList<>();
           Map<String, List<AdresseParCaserne>> map = new HashMap<>();
           for (int i = 0; i < jsonReaderFile.JsonReaderFileFireStation().size(); i++) {
               if (jsonReaderFile.JsonReaderFileFireStation().path(i).path("station").asText().equals(firestationnumberstring)) {
                   for (int j = 0; j < jsonReaderFile.JsonReaderFilePerson().size(); j++) {
                       if (jsonReaderFile.JsonReaderFilePerson().path(j).path("address").equals(jsonReaderFile.JsonReaderFileFireStation().path(i).path("address"))) {
                           for (int k = 0; k < jsonReaderFile.JsonReaderFileMedicalRecords().size(); k++) {
                               AdresseParCaserne adresseParCaserne = new AdresseParCaserne();
                               List<String> medicalbackgroundlist = new LinkedList<>();
                               if (jsonReaderFile.JsonReaderFilePerson().path(j).path("firstName").equals(jsonReaderFile.JsonReaderFileMedicalRecords().path(k).path("firstName"))) {
                                   adresseParCaserne.setFirstName(jsonReaderFile.JsonReaderFilePerson().path(j).path("firstName").toString());
                                   adresseParCaserne.setPhone(jsonReaderFile.JsonReaderFilePerson().path(j).path("phone").toString());
                                   medicalbackgroundlist.add(jsonReaderFile.JsonReaderFileMedicalRecords().path(k).path("allergies").toString());
                                   medicalbackgroundlist.add(jsonReaderFile.JsonReaderFileMedicalRecords().path(k).path("medications").toString());
                                   adresseParCaserne.setMedicalbackgroundlist(medicalbackgroundlist);
                                   adresseParCaserne.setAge(age(jsonReaderFile.JsonReaderFileMedicalRecords().path(k)));
                                   adresseParCaserneList.add(adresseParCaserne);
                                   map.put(jsonReaderFile.JsonReaderFileFireStation().path(i).path("station").toString(), adresseParCaserneList);


                               }

                           }
                       }

                   }
               }
           }

           StationAddressList.add(map);
       }
       return StationAddressList;
    }

    private int age(JsonNode jsonNode){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(jsonNode.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age;

    }
}
