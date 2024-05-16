package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class FireStationController {

    @PostMapping("http://localhost:8080/firestation/{firestation}")
    public void addFireStation(@PathVariable("firestation") Firestations firestations) throws IOException {
        PostFireStation postFireStation = new PostFireStation();
        postFireStation.addFireStation(firestations);

    }

    @PutMapping("http://localhost:8080/firestation/{firestation}")
    public void updateExistingFireStation(@PathVariable("firestation") Firestations firestations) throws IOException {
        UpdateFireStation updateFireStation = new UpdateFireStation();
        updateFireStation.updateFireStations(firestations);
    }

    @DeleteMapping("http://localhost:8080/firestation/{firestation}")
    public void removeFireStation(@PathVariable("firestation") Firestations firestations) throws IOException {
        DeletFireStation deletFireStation = new DeletFireStation();
        deletFireStation.deleteFireStations(firestations);
    }
}
