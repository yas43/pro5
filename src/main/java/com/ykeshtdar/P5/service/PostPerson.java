package com.ykeshtdar.P5.service;



import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.repository.*;

import java.io.*;
import java.util.*;

public class PostPerson {
    Repository repository =new Repository();

     public List<Person> postPersontolist(Person person) throws IOException {
        List<Person>  personList = repository.pesonRepo();
        personList.add(person);
        return personList;

    }
}
