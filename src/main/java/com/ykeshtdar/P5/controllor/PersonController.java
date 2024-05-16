package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class PersonController {
    @PostMapping("http://localhost:8080/person/{person}")
    public void addPerson(@PathVariable("person") Person person) throws IOException {
        PostPerson postPerson = new PostPerson();
        postPerson.postPersontolist(person);
    }

    @PutMapping("http://localhost:8080/person/{person}")
    public void updateexistingperson(@PathVariable("person") Person person) throws IOException {
        UpdatrPerson updatrPerson = new UpdatrPerson();
        updatrPerson.updatrPerson(person);
    }

    @DeleteMapping("http://localhost:8080/person/{person}")
    public void deleteExistingPerson(@PathVariable("person") Person person) throws IOException {
        DeletePerson deletePerson = new DeletePerson();
        deletePerson.deletPerson(person);
    }
}
