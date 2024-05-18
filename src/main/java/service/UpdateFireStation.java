package service;





import model.*;
import org.springframework.stereotype.*;
import repository.*;
import repository.Repository;

import java.io.*;
import java.util.*;
@Service
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
