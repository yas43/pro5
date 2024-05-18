package service;





import model.*;
import org.springframework.stereotype.*;
import repository.*;
import repository.Repository;

import java.io.*;
import java.util.*;
@Service
public class PostMedicalRecord {
     Repository repository = new Repository();

     public List<Medicalrecords> addMedicalRecords(Medicalrecords medicalrecords) throws IOException {
         List<Medicalrecords> medicalrecordsList = repository.medicalrecordsRepo();

         medicalrecordsList.add(medicalrecords);

         return medicalrecordsList;
     }
 }
