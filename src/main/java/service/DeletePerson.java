package service;





import model.*;
import org.springframework.stereotype.*;
import repository.*;
import repository.Repository;

import java.io.*;
import java.util.*;
@Service
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
