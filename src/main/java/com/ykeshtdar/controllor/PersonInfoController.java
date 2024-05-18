package com.ykeshtdar.controllor;

import com.ykeshtdar.service.PersonInfoServices;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.io.*;

@RestController
public class PersonInfoController {
    @Autowired
    PersonInfoServices personInfoServices;
    @GetMapping("http://localhost:8080/personInfo/{firstName}")
    @ResponseBody
    public void personInfo(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) throws IOException {
//        PersonInfoServices personInfoServices = new PersonInfoServices();
        personInfoServices.personInfo(firstName,lastName);

    }
}
