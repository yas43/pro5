package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
public class FloodControllere {
    @GetMapping("http://localhost:8080/flood/{listOfStation}")
    public void flood(@PathVariable("listOfStation") List<Integer> list) throws IOException {
        AdressParCasernServices adressParCasernServices = new AdressParCasernServices();
        adressParCasernServices.addresseesForFireStation(list);

    }
}
