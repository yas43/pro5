package com.ykeshtdar.P5.service;



import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.repository.*;

import java.io.*;
import java.util.*;

public class UpdateFireStation {
     Repository repository = new Repository();
     public List<Firestations> updateFireStations(Firestations firestations) throws IOException {
          List<Firestations> firestationsList = repository.firestationRepo();
          for (int i=0;i<firestationsList.size();i++){
              if (firestationsList.get(i).getAddress().replace("\"", "").equalsIgnoreCase(firestations.getAddress())){
//                  System.out.println(firestationsList.get(i).getStation());
                  firestationsList.get(i).setStation(firestations.getStation());
              }

          }

         return  firestationsList;
     }
}
