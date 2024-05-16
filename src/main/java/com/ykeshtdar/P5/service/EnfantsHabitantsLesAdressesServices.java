package com.ykeshtdar.P5.service;


import com.fasterxml.jackson.databind.*;
import com.ykeshtdar.P5.dto.*;
import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.reader.*;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class EnfantsHabitantsLesAdressesServices {
    JsonReaderFile jsonReaderFile = new JsonReaderFile();
    List<EnfantsHabitantsLesAddress> enfantsHabitantsLesAddressList = new LinkedList<>();
    List<Person> personList = new LinkedList<>();

    public List<EnfantsHabitantsLesAddress> childForEachAddress(String address) throws IOException {
        for (int i=0;i<jsonReaderFile.JsonReaderFilePerson().size();i++){
            if(jsonReaderFile.JsonReaderFilePerson().path(i).path("address").asText().equals(address)){
                for (int j=0;j<jsonReaderFile.JsonReaderFileMedicalRecords().size();j++){
                    EnfantsHabitantsLesAddress enfantsHabitantsLesAddress = new EnfantsHabitantsLesAddress();
                    if (jsonReaderFile.JsonReaderFileMedicalRecords().path(j).path("firstName").equals(jsonReaderFile.JsonReaderFilePerson().path(i).path("firstName"))
                    &&jsonReaderFile.JsonReaderFileMedicalRecords().path(j).path("lastName").equals(jsonReaderFile.JsonReaderFilePerson().path(i).path("lastName"))
                    && isKid(jsonReaderFile.JsonReaderFileMedicalRecords().path(j))){
                        enfantsHabitantsLesAddress.setName(jsonReaderFile.JsonReaderFilePerson().path(i).path("firstName").toString());
                        enfantsHabitantsLesAddress.setFamilyName(jsonReaderFile.JsonReaderFilePerson().path(i).path("lastName").toString());
                        enfantsHabitantsLesAddress.setAge(age(jsonReaderFile.JsonReaderFileMedicalRecords().path(j)));
                        enfantsHabitantsLesAddress.setPersonList(householdMembers());

                        enfantsHabitantsLesAddressList.add(enfantsHabitantsLesAddress);
                    }
                }
            }
        }
        return enfantsHabitantsLesAddressList;
    }

    private boolean isKid(JsonNode jsonNode){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(jsonNode.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age < 18;


    }

    public boolean isAdult(JsonNode jsonNode){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(jsonNode.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age > 18;


    }

    private int age(JsonNode jsonNode){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(jsonNode.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age;

    }
    public List<Person> householdMembers() throws IOException {

        for (int i=0;i<jsonReaderFile.JsonReaderFilePerson().size();i++) {
            for (int j = 0; j < jsonReaderFile.JsonReaderFileMedicalRecords().size();j++) {
                Person person = new Person();
                if (jsonReaderFile.JsonReaderFilePerson().path(i).path("firstName").equals(jsonReaderFile.JsonReaderFileMedicalRecords().path(j).path("firstName"))
                && isAdult(jsonReaderFile.JsonReaderFileMedicalRecords().path(j))) {
                    person.setFirstName(jsonReaderFile.JsonReaderFilePerson().path(i).path("firstName").toString());
                    person.setLastName(jsonReaderFile.JsonReaderFilePerson().path(i).path("lastName").toString());
                    person.setAddress(jsonReaderFile.JsonReaderFilePerson().path(i).path("address").toString());
                    person.setCity(jsonReaderFile.JsonReaderFilePerson().path(i).path("city").toString());
                    person.setZip(jsonReaderFile.JsonReaderFilePerson().path(i).path("zip").toString());
                    person.setPhone(jsonReaderFile.JsonReaderFilePerson().path(i).path("phone").toString());
                    person.setEmail(jsonReaderFile.JsonReaderFilePerson().path(i).path("email").toString());

                    personList.add(person);

                }

            }
        }
       return personList;
    }
}
