package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class FireController {
    @GetMapping("http://localhost:8080/fire/{address}")
    public void fire(@PathVariable("address") String address) throws IOException {
        HabitantsParAdressService habitantsParAdressService = new HabitantsParAdressService();
        habitantsParAdressService.personaddress(address);

    }
}
