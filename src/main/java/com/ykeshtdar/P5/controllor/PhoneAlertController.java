package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController

public class PhoneAlertController {
    @GetMapping("http://localhost:8080/phoneAlert/{firestation_number}")
    public void phoneAlert(@PathVariable("firestation_number") int firestation_number) throws IOException {
        NumérosTelephoneParCaserneService numérosTelephoneParCaserneService = new NumérosTelephoneParCaserneService();
        numérosTelephoneParCaserneService.phoneNumbers(firestation_number);

    }
}
