package com.ykeshtdar.service;





import com.ykeshtdar.model.Firestations;
import com.ykeshtdar.repository.Repository;

import org.springframework.stereotype.*;


import java.io.*;
import java.util.*;
@Service
public class DeletFireStation {
    com.ykeshtdar.repository.Repository repository = new Repository();
    public List<Firestations> deleteFireStations(Firestations firestations) throws IOException {
        List<Firestations> firestationsList = repository.firestationRepo();
        List<Firestations> firestationsListdeleted = new LinkedList<>();
        for (int i = 0; i < firestationsList.size(); i++) {

            if (firestationsList.get(i).getAddress().replace("\"", "").equalsIgnoreCase(firestations.getAddress())
                    || firestationsList.get(i).getStation().replace("\"", "").equalsIgnoreCase(firestations.getStation())) {

//                firestationsList.remove(firestationsList.get(i));
                firestationsListdeleted.add(firestationsList.get(i));


            }
        }
        for (Firestations firestations1:firestationsListdeleted){
            firestationsList.remove(firestations1);
        }
        return firestationsList;
    }
}
