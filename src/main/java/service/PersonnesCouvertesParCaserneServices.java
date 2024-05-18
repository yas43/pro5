package service;


import com.fasterxml.jackson.databind.*;


import dto.*;
import model.*;
import org.springframework.stereotype.*;
import reader.*;

import java.io.*;
import java.util.*;
@Service
public class PersonnesCouvertesParCaserneServices {
    JsonReaderFile jsonReaderFile = new JsonReaderFile();

    public List<PersonnesCouvertesParCaserne> coveredpersonsRepo(int stationnumber) throws IOException {

        List<PersonnesCouvertesParCaserne> couvertesParCasernes = new LinkedList<>();
        JsonNode fireStations = jsonReaderFile.JsonReaderFileFireStation();
        //        JsonNode medicalrecords = jsonReaderFile.JsonReaderFileMedicalRecords();
        JsonNode persons = jsonReaderFile.JsonReaderFilePerson();


        Person person1 = new Person();
        String firestationnumberstring = String.valueOf(stationnumber);
        for (int i = 0; i < fireStations.size(); i++) {
            if (fireStations.path(i).path("station").asText().equals(firestationnumberstring)) {
                for (int j = 0; j < persons.size(); j++) {
                    PersonnesCouvertesParCaserne personnesCouvertesParCaserne = new PersonnesCouvertesParCaserne();
                    if (persons.path(j).path("address").equals(fireStations.path(i).path("address"))) {

                        personnesCouvertesParCaserne.setFirstName(persons.path(j).path("firstName").toString());
                        personnesCouvertesParCaserne.setLastName(persons.path(j).path("lastName").toString());
                        personnesCouvertesParCaserne.setAdresse(persons.path(j).path("address").toString());
                        personnesCouvertesParCaserne.setPhone(persons.path(j).path("phone").toString());

                        couvertesParCasernes.add(personnesCouvertesParCaserne);
                    }
                    //                                        System.out.println(persons.path(j).path("firstName"));

                }
            }
        }
        return couvertesParCasernes;
    }
}
