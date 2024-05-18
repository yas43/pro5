package dto;


import com.fasterxml.jackson.databind.*;
import reader.*;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
// this class corresponding to "http://localhost:8080/firestation?stationNumber=<station_number>"

public class PersonnesCouvertesParCaserne {
    String firstName;
    String lastName;
    String adresse;
    String phone;
    boolean isAdults;
    boolean isKids;
    String numberOfAdults;
    String numberOfKids;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPhone() {
        return phone;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNumberOfAdults(String numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public void setNumberOfKids(String numberOfKids) {
        this.numberOfKids = numberOfKids;
    }

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
            for (JsonNode medicalrecord:jsonReaderFile.JsonReaderFileMedicalRecords()){
                if(personnesCouvertesParCaserne.isAdults(medicalrecord)){
                    counter++;

                }

            }


        setNumberOfAdults( "number of Adult is " +counter);
}


    public void numberOfKids() throws IOException {
        JsonReaderFile jsonReaderFile = new JsonReaderFile();
        PersonnesCouvertesParCaserne personnesCouvertesParCaserne = new PersonnesCouvertesParCaserne();
        int counter = 0;
        for (JsonNode medicalrecord:jsonReaderFile.JsonReaderFileMedicalRecords()){
            if(personnesCouvertesParCaserne.isKids(medicalrecord)){
                counter++;

            }

        }


        setNumberOfKids("number of kids is " +counter);
    }




    @Override
    public String toString() {
        return "PersonnesCouvertesParCaserne{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adresse='" + adresse + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfAdults='" + numberOfAdults + '\'' +
                ", numberOfKids='" + numberOfKids + '\'' +
                '}';
    }
}
