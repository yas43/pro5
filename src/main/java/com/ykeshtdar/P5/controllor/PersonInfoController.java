package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class PersonInfoController {
    @GetMapping("http://localhost:8080/personInfo/{firstName}")
    public void personInfo(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) throws IOException {
        PersonInfoServices personInfoServices = new PersonInfoServices();
        personInfoServices.personInfo(firstName,lastName);

    }
}
