package com.ykeshtdar.controllor;

import com.ykeshtdar.service.EnfantsHabitantsLesAdressesServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.io.*;

@RestController
public class ChildAlertController {

   private final EnfantsHabitantsLesAdressesServices enfantsHabitantsLesAdressesServices;

    public ChildAlertController(EnfantsHabitantsLesAdressesServices enfantsHabitantsLesAdressesServices) {
        this.enfantsHabitantsLesAdressesServices = enfantsHabitantsLesAdressesServices;
    }

    @GetMapping("http://localhost:8080/childAlert/{address}")
    @ResponseBody
    public void childAlert(@PathVariable("address") String address) throws IOException {
         enfantsHabitantsLesAdressesServices.childForEachAddress(address);

    }
}
