package controllor;



import model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.io.*;

@RestController
public class PersonController {
    @Autowired
    PostPerson postPerson;
    @Autowired
    UpdatrPerson updatrPerson;
    @Autowired
    DeletePerson deletePerson;
    @PostMapping("http://localhost:8080/person/{person}")
    @ResponseBody
    public void addPerson(@PathVariable("person") Person person) throws IOException {
//        PostPerson postPerson = new PostPerson();
        postPerson.postPersontolist(person);
    }

    @PutMapping("http://localhost:8080/person/{person}")
    @ResponseBody
    public void updateexistingperson(@PathVariable("person") Person person) throws IOException {
//        UpdatrPerson updatrPerson = new UpdatrPerson();
        updatrPerson.updatrPerson(person);
    }

    @DeleteMapping("http://localhost:8080/person/{person}")
    @ResponseBody
    public void deleteExistingPerson(@PathVariable("person") Person person) throws IOException {
//        DeletePerson deletePerson = new DeletePerson();
        deletePerson.deletPerson(person);
    }
}
