package com.ykeshtdar.service;





import com.ykeshtdar.model.Firestations;
import com.ykeshtdar.repository.Repository;

import org.springframework.stereotype.*;


import java.io.*;
import java.util.*;
@Service
public class UpdateFireStation {
     com.ykeshtdar.repository.Repository repository = new Repository();
     public List<Firestations> updateFireStations(Firestations firestations) throws IOException {
          List<Firestations> firestationsList = repository.firestationRepo();
          for (int i=0;i<firestationsList.size();i++){
              if (firestationsList.get(i).getAddress().replace("\"", "").equalsIgnoreCase(firestations.getAddress())){

                  firestationsList.get(i).setStation(firestations.getStation());
              }

          }

         return  firestationsList;
     }
}
