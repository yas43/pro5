package com.ykeshtdar.P5.service;



import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.repository.*;

import java.io.*;
import java.util.*;

public class UpdateMedicalRecord {
    Repository repository = new Repository();
    public List<Medicalrecords> updatMedicalRecords(Medicalrecords medicalrecords) throws IOException {
        List<Medicalrecords> medicalrecordsList = repository.medicalrecordsRepo();
        for (int i=0;i<medicalrecordsList.size();i++){
            if (medicalrecordsList.get(i).getFirstName().replace("\"", "").equalsIgnoreCase(medicalrecords.getFirstName())
            && medicalrecordsList.get(i).getLastName().replace("\"", "").equalsIgnoreCase(medicalrecords.getLastName())){

                if (medicalrecords.getMedications() != null && !(medicalrecords.getMedications().isEmpty())){
                    medicalrecordsList.get(i).setMedications(medicalrecords.getMedications());
                }
                else {
                    medicalrecordsList.get(i).setMedications(medicalrecordsList.get(i).getMedications());
                }


                if (medicalrecords.getBirthdate() != null &&  !(medicalrecords.getBirthdate().isEmpty())){
                    medicalrecordsList.get(i).setBirthdate(medicalrecords.getBirthdate());
                }
                else {
                    medicalrecordsList.get(i).setBirthdate(medicalrecordsList.get(i).getBirthdate());
                }


                if (medicalrecords.getAllergies() != null && !(medicalrecords.getAllergies().isEmpty())){
                    medicalrecordsList.get(i).setAllergies(medicalrecords.getAllergies());
                }
                else {
                    medicalrecordsList.get(i).setAllergies(medicalrecordsList.get(i).getAllergies());
                }
            }
        }
        return medicalrecordsList;
    }
}
