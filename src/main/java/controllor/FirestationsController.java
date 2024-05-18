package controllor;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.io.*;

@RestController
public class FirestationsController {
    @Autowired
    PersonnesCouvertesParCaserneServices personnesCouvertesParCaserneServices;
    @GetMapping("http://localhost:8080/firestation/{station_number}")
    @ResponseBody
    public void firestation(@PathVariable("station_number") int station_number) throws IOException {
//        PersonnesCouvertesParCaserneServices personnesCouvertesParCaserneServices = new PersonnesCouvertesParCaserneServices();
        System.out.println("i am here yaser");
        personnesCouvertesParCaserneServices.coveredpersonsRepo(station_number);


    }
}
