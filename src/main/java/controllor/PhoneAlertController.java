package controllor;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.io.*;

@RestController

public class PhoneAlertController {
    @Autowired
    NumerosTelephoneParCaserneService numerosTelephoneParCaserneService;
    @GetMapping("http://localhost:8080/phoneAlert/{firestation_number}")
    @ResponseBody
    public void phoneAlert(@PathVariable("firestation_number") int firestation_number) throws IOException {
//        NumerosTelephoneParCaserneService numerosTelephoneParCaserneService = new NumerosTelephoneParCaserneService();
        numerosTelephoneParCaserneService.phoneNumbers(firestation_number);

    }
}
