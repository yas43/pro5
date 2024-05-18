package controllor;


import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.io.*;

@RestController
public class FireController {
    @Autowired
    HabitantsParAdressService habitantsParAdressService;
    @GetMapping("http://localhost:8080/fire/{address}")
    @ResponseBody
    public void fire(@PathVariable("address") String address) throws IOException {
//        HabitantsParAdressService habitantsParAdressService = new HabitantsParAdressService();
        habitantsParAdressService.personaddress(address);

    }
}
