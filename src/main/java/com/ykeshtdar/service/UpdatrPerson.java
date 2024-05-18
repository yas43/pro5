package com.ykeshtdar.service;





import com.ykeshtdar.model.Person;
import com.ykeshtdar.repository.Repository;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;
@Service
public class UpdatrPerson {
    com.ykeshtdar.repository.Repository repository = new Repository();


    public List<Person> updatrPerson(Person person) throws IOException {
        List<Person> personList = repository.pesonRepo();
//        System.out.println(personList);
        for (Person value : personList) {

            if (value.getFirstName().replace("\"", "").equalsIgnoreCase(person.getFirstName())
                    && value.getLastName().replace("\"", "").equalsIgnoreCase(person.getLastName())) {
                if (person.getAddress() != null && !(person.getAddress().isEmpty())) {
                    value.setAddress(person.getAddress());
                }
                if (person.getAddress().isEmpty()) {
                    value.setAddress(value.getAddress());
                }

                if (person.getCity() != null && !(person.getCity().isEmpty())) {
                    value.setCity(person.getCity());
                }
                if (person.getCity().isEmpty()) {
                    value.setCity(value.getCity());
                }

                if (person.getZip() != null && !(person.getZip().isEmpty())) {
                    value.setZip(person.getZip());
                }
                if (person.getZip().isEmpty()) {
                    value.setZip(value.getZip());
                }

                if (person.getPhone() != null && !(person.getPhone().isEmpty())) {
                    value.setPhone(person.getPhone());
                }
                if (person.getPhone().isEmpty()) {
                    value.setPhone(value.getPhone());
                }

                if (person.getEmail() != null && !(person.getEmail().isEmpty())) {
                    value.setEmail(person.getEmail());
                }
                if (person.getEmail().isEmpty()) {
                    value.setEmail(value.getEmail());
                }
            }
        }
        return personList;
    }
}
