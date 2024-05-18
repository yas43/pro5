package service;




import model.*;
import org.springframework.stereotype.*;
import repository.*;
import repository.Repository;

import java.io.*;
import java.util.*;
@Service
public class PostFireStation {
   Repository repository = new Repository();



    public List<Firestations> addFireStation(Firestations firestations) throws IOException {
        List<Firestations> firestationsList = repository.firestationRepo();
        firestationsList.add(firestations);
        return firestationsList;



    }
}
