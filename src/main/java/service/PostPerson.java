package service;





import model.*;
import org.springframework.stereotype.*;
import repository.*;
import repository.Repository;

import java.io.*;
import java.util.*;
@Service
public class PostPerson {
    Repository repository =new Repository();

     public List<Person> postPersontolist(Person person) throws IOException {
        List<Person>  personList = repository.pesonRepo();
        personList.add(person);
        return personList;

    }
}
