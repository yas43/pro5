package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class FirestationsController {
    @GetMapping("http://localhost:8080/firestation/{station_number}")
    public void firestation(@PathVariable("station_number") int station_number) throws IOException {
        PersonnesCouvertesParCaserneServices personnesCouvertesParCaserneServices = new PersonnesCouvertesParCaserneServices();
        personnesCouvertesParCaserneServices.coveredpersonsRepo(station_number);


    }
}
