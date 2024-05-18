package com.ykeshtdar.service;





import com.ykeshtdar.model.Medicalrecords;
import com.ykeshtdar.repository.Repository;

import org.springframework.stereotype.*;


import java.io.*;
import java.util.*;
@Service
public class PostMedicalRecord {
     com.ykeshtdar.repository.Repository repository = new Repository();

     public List<Medicalrecords> addMedicalRecords(Medicalrecords medicalrecords) throws IOException {
         List<Medicalrecords> medicalrecordsList = repository.medicalrecordsRepo();

         medicalrecordsList.add(medicalrecords);

         return medicalrecordsList;
     }
 }
