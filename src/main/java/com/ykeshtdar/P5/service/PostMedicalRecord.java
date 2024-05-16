package com.ykeshtdar.P5.service;



import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.repository.*;

import java.io.*;
import java.util.*;

public class PostMedicalRecord {
     Repository repository = new Repository();

     public List<Medicalrecords> addMedicalRecords(Medicalrecords medicalrecords) throws IOException {
         List<Medicalrecords> medicalrecordsList = repository.medicalrecordsRepo();

         medicalrecordsList.add(medicalrecords);

         return medicalrecordsList;
     }
 }
