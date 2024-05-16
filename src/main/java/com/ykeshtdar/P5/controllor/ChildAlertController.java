package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class ChildAlertController {
    @GetMapping("http://localhost:8080/childAlert/{address}")
    public void childAlert(@PathVariable("address") String address) throws IOException {
        EnfantsHabitantsLesAdressesServices enfantsHabitantsLesAdressesServices = new EnfantsHabitantsLesAdressesServices();
         enfantsHabitantsLesAdressesServices.childForEachAddress(address);

    }
}
