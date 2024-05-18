package com.ykeshtdar.controllor;

import com.ykeshtdar.service.NumerosTelephoneParCaserneService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;


import java.io.*;

@RestController

public class PhoneAlertController {
    @Autowired
    private final NumerosTelephoneParCaserneService numerosTelephoneParCaserneService;

    public PhoneAlertController(NumerosTelephoneParCaserneService numerosTelephoneParCaserneService) {
        this.numerosTelephoneParCaserneService = numerosTelephoneParCaserneService;
    }

    @GetMapping("/phoneAlert/{firestation_number}")
    @ResponseBody
    public void phoneAlert(@PathVariable("firestation_number") int firestation_number) throws IOException {
//        NumerosTelephoneParCaserneService numerosTelephoneParCaserneService = new NumerosTelephoneParCaserneService();
        numerosTelephoneParCaserneService.phoneNumbers(firestation_number);

    }
}
