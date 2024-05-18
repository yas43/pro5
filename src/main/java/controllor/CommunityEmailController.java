package controllor;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.io.*;

@RestController
public class CommunityEmailController {
    @Autowired
    CommunityEmailServices communityEmailServices;
    @GetMapping("http://localhost:8080/communityEmail/{city}")
    @ResponseBody
    public void communityEmail(@PathVariable("city") String city) throws IOException {
//        CommunityEmailServices communityEmailServices = new CommunityEmailServices();
        communityEmailServices.communityEmail(city);

    }
}
