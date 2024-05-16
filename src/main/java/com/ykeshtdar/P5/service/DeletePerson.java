package com.ykeshtdar.P5.service;



import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.repository.*;

import java.io.*;
import java.util.*;

public class DeletePerson {
    Repository repository = new Repository();
    public List<Person> deletPerson(Person person) throws IOException {
        List<Person> personList = repository.pesonRepo();
        for (int i = 0; i < personList.size(); i++) {

            if (personList.get(i).getFirstName().replace("\"", "").equalsIgnoreCase(person.getFirstName())
                    && personList.get(i).getLastName().replace("\"", "").equalsIgnoreCase(person.getLastName())) {
                personList.remove(personList.get(i));


            }
        }
        return personList;
    }
}
