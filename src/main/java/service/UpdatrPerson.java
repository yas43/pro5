package service;





import model.*;
import org.springframework.stereotype.*;
import repository.*;
import repository.Repository;

import java.io.*;
import java.util.*;
@Service
public class UpdatrPerson {
    Repository repository = new Repository();


    public List<Person> updatrPerson(Person person) throws IOException {
        List<Person> personList = repository.pesonRepo();
//        System.out.println(personList);
        for (int i = 0; i < personList.size(); i++) {

            if (personList.get(i).getFirstName().replace("\"", "").equalsIgnoreCase(person.getFirstName())
                    && personList.get(i).getLastName().replace("\"", "").equalsIgnoreCase(person.getLastName())) {
                if (person.getAddress() != null && !(person.getAddress().isEmpty())) {
                    personList.get(i).setAddress(person.getAddress());
                }
                if (person.getAddress().isEmpty()) {
                    personList.get(i).setAddress(personList.get(i).getAddress());
                }

                if (person.getCity() != null && !(person.getCity().isEmpty())) {
                    personList.get(i).setCity(person.getCity());
                }
                if (person.getCity().isEmpty()) {
                    personList.get(i).setCity(personList.get(i).getCity());
                }

                if (person.getZip() != null && !(person.getZip().isEmpty())) {
                    personList.get(i).setZip(person.getZip());
                }
                if (person.getZip().isEmpty()) {
                    personList.get(i).setZip(personList.get(i).getZip());
                }

                if (person.getPhone() != null && !(person.getPhone().isEmpty())) {
                    personList.get(i).setPhone(person.getPhone());
                }
                if (person.getPhone().isEmpty()) {
                    personList.get(i).setPhone(personList.get(i).getPhone());
                }

                if (person.getEmail() != null && !(person.getEmail().isEmpty())) {
                    personList.get(i).setEmail(person.getEmail());
                }
                if (person.getEmail().isEmpty()) {
                    personList.get(i).setEmail(personList.get(i).getEmail());
                }
            }
        }
        return personList;
    }
}
