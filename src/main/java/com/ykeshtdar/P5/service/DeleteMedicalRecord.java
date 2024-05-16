package com.ykeshtdar.P5.service;



import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.repository.*;

import java.io.*;
import java.util.*;

public class DeleteMedicalRecord {
    Repository repository = new Repository();
    public List<Medicalrecords> deletMedicalRecrd(Medicalrecords medicalrecords) throws IOException {
        List<Medicalrecords> medicalrecordsList = repository.medicalrecordsRepo();
        for (int i=0;i<medicalrecordsList.size();i++){
            if (medicalrecordsList.get(i).getFirstName().replace("\"", "").equalsIgnoreCase(medicalrecords.getFirstName())
            && medicalrecordsList.get(i).getLastName().replace("\"", "").equalsIgnoreCase(medicalrecords.getLastName())){
                medicalrecordsList.remove(medicalrecordsList.get(i));
            }
        }
        return medicalrecordsList;
    }
}
