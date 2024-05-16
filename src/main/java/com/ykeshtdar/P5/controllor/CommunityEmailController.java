package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class CommunityEmailController {
    @GetMapping("http://localhost:8080/communityEmail/{city}")
    public void communityEmail(@PathVariable("city") String city) throws IOException {
        CommunityEmailServices communityEmailServices = new CommunityEmailServices();
        communityEmailServices.communityEmail(city);

    }
}
