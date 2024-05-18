package controllor;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.io.*;

@RestController
public class ChildAlertController {
    @Autowired
    EnfantsHabitantsLesAdressesServices enfantsHabitantsLesAdressesServices;
    @GetMapping("http://localhost:8080/childAlert/{address}")
    @ResponseBody
    public void childAlert(@PathVariable("address") String address) throws IOException {
//        EnfantsHabitantsLesAdressesServices enfantsHabitantsLesAdressesServices = new EnfantsHabitantsLesAdressesServices();
         enfantsHabitantsLesAdressesServices.childForEachAddress(address);

    }
}
