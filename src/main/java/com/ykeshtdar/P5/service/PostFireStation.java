package com.ykeshtdar.P5.service;



import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.repository.*;

import java.io.*;
import java.util.*;

public class PostFireStation {
   Repository repository = new Repository();



    public List<Firestations> addFireStation(Firestations firestations) throws IOException {
        List<Firestations> firestationsList = repository.firestationRepo();
        firestationsList.add(firestations);
        return firestationsList;



    }
}
