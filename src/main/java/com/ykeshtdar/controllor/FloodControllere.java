package com.ykeshtdar.controllor;


import com.ykeshtdar.service.AdressParCasernServices;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
public class FloodControllere {
    @Autowired
    AdressParCasernServices adressParCasernServices;
    @GetMapping("http://localhost:8080/flood/{listOfStation}")
    @ResponseBody
    public void flood(@PathVariable("listOfStation") List<Integer> list) throws IOException {
//        AdressParCasernServices adressParCasernServices = new AdressParCasernServices();
        adressParCasernServices.addresseesForFireStation(list);

    }
}
