package com.ykeshtdar.controllor;

import com.ykeshtdar.dto.PersonnesCouvertesParCaserne;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ykeshtdar.service.PersonnesCouvertesParCaserneServices;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/personnes")
public class FirestationsController {

    private final PersonnesCouvertesParCaserneServices personnesCouvertesParCaserneServices;

    public FirestationsController(PersonnesCouvertesParCaserneServices personnesCouvertesParCaserneServices) {
        this.personnesCouvertesParCaserneServices = personnesCouvertesParCaserneServices;
    }

    @GetMapping("/firestation/{station_number}")
    public ResponseEntity<List<PersonnesCouvertesParCaserne>> fireStation(@PathVariable("station_number") int station_number) throws IOException {
        return new ResponseEntity<>(personnesCouvertesParCaserneServices.coveredPersonsRepo(station_number), HttpStatus.OK);

    }
}
