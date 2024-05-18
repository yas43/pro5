package controllor;



import model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.io.*;

@RestController
public class FireStationController {
@Autowired
PostFireStation postFireStation;
@Autowired
UpdateFireStation updateFireStation;
@Autowired
DeletFireStation deletFireStation;
    @PostMapping("http://localhost:8080/firestation/{firestation}")
    @ResponseBody
    public void addFireStation(@PathVariable("firestation") Firestations firestations) throws IOException {
//        PostFireStation postFireStation = new PostFireStation();
        postFireStation.addFireStation(firestations);

    }

    @PutMapping("http://localhost:8080/firestation/{firestation}")
    @ResponseBody
    public void updateExistingFireStation(@PathVariable("firestation") Firestations firestations) throws IOException {
//        UpdateFireStation updateFireStation = new UpdateFireStation();
        updateFireStation.updateFireStations(firestations);
    }

    @DeleteMapping("http://localhost:8080/firestation/{firestation}")
    @ResponseBody
    public void removeFireStation(@PathVariable("firestation") Firestations firestations) throws IOException {
//        DeletFireStation deletFireStation = new DeletFireStation();
        deletFireStation.deleteFireStations(firestations);
    }
}
