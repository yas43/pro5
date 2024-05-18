package com.ykeshtdar.service;




import com.ykeshtdar.model.Firestations;
import com.ykeshtdar.repository.Repository;

import org.springframework.stereotype.*;


import java.io.*;
import java.util.*;
@Service
public class PostFireStation {
   com.ykeshtdar.repository.Repository repository = new Repository();



    public List<Firestations> addFireStation(Firestations firestations) throws IOException {
        List<Firestations> firestationsList = repository.firestationRepo();
        firestationsList.add(firestations);
        return firestationsList;



    }
}
