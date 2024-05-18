package com.ykeshtdar.dto;


import com.fasterxml.jackson.databind.JsonNode;
import com.ykeshtdar.reader.JsonReaderFile;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// this class corresponding to "http://localhost:8080/firestation?stationNumber=<station_number>"
@Getter
@Setter
public class PersonnesCouvertesParCaserne {
    private String firstName;
    private String lastName;
    private String adresse;
    private String phone;
    private boolean isAdults;
    private boolean isKids;
    private String numberOfAdults;
    private String numberOfKids;


    public boolean isAdults(JsonNode person) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(person.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age > 18;

    }

    public boolean isKids(JsonNode person) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\"MM/dd/yyyy\"", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.now();
        LocalDate personBirthdate = LocalDate.parse(person.path("birthdate").toString(), formatter);
        int age = Period.between(personBirthdate, currentDate).getYears();
        return age < 18;

    }

    public void numberOfAdults() throws IOException {
        JsonReaderFile jsonReaderFile = new JsonReaderFile();
        PersonnesCouvertesParCaserne personnesCouvertesParCaserne = new PersonnesCouvertesParCaserne();
        int counter = 0;
        for (JsonNode medicalrecord : jsonReaderFile.JsonReaderFileMedicalRecords()) {
            if (personnesCouvertesParCaserne.isAdults(medicalrecord)) {
                counter++;

            }

        }


        setNumberOfAdults("number of Adult is " + counter);
    }


    public void numberOfKids() throws IOException {
        JsonReaderFile jsonReaderFile = new JsonReaderFile();
        PersonnesCouvertesParCaserne personnesCouvertesParCaserne = new PersonnesCouvertesParCaserne();
        int counter = 0;
        for (JsonNode medicalrecord : jsonReaderFile.JsonReaderFileMedicalRecords()) {
            if (personnesCouvertesParCaserne.isKids(medicalrecord)) {
                counter++;

            }

        }


        setNumberOfKids("number of kids is " + counter);
    }


    @Override
    public String toString() {
        return "PersonnesCouvertesParCaserne{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", adresse='" + adresse + '\'' + ", phone='" + phone + '\'' + ", numberOfAdults='" + numberOfAdults + '\'' + ", numberOfKids='" + numberOfKids + '\'' + '}';
    }
}
