package com.ykeshtdar.controllor;

import com.ykeshtdar.service.CommunityEmailServices;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;


import java.io.*;

@RestController
public class CommunityEmailController {
    @Autowired
    CommunityEmailServices communityEmailServices;
    @GetMapping("http://localhost:8080/communityEmail/{city}")
    @ResponseBody
    public void communityEmail(@PathVariable("city") String city) throws IOException {
        communityEmailServices.communityEmail(city);

    }
}
