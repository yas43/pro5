package com.ykeshtdar.service;





import com.ykeshtdar.model.Person;
import com.ykeshtdar.repository.Repository;

import org.springframework.stereotype.*;


import java.io.*;
import java.util.*;
@Service
public class PostPerson {
    com.ykeshtdar.repository.Repository repository =new Repository();

     public List<Person> postPersontolist(Person person) throws IOException {
        List<Person>  personList = repository.pesonRepo();
        personList.add(person);
        return personList;

    }
}
