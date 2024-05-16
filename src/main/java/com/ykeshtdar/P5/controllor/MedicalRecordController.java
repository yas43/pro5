package com.ykeshtdar.P5.controllor;

import com.ykeshtdar.P5.model.*;
import com.ykeshtdar.P5.service.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
public class MedicalRecordController {

    @PostMapping("http://localhost:8080/medicalRecord/{medicalrecord}")
    public void addMedicalRecord(@PathVariable("medicalrecord") Medicalrecords medicalrecords) throws IOException {
        PostMedicalRecord postMedicalRecord = new PostMedicalRecord();
        postMedicalRecord.addMedicalRecords(medicalrecords);
    }

    @PutMapping("http://localhost:8080/medicalRecord/{medicalrecord}")
    public void updateExistingFireStation(@PathVariable("medicalrecord") Medicalrecords medicalrecords) throws IOException {
        UpdateMedicalRecord updateMedicalRecord = new UpdateMedicalRecord();
        updateMedicalRecord.updatMedicalRecords(medicalrecords);
    }

    @DeleteMapping("http://localhost:8080/medicalRecord/{medicalrecord}")
    public void removeExistingMedicalRecord(@PathVariable("medicalrecord") Medicalrecords medicalrecords) throws IOException {
        DeleteMedicalRecord deleteMedicalRecord = new DeleteMedicalRecord();
        deleteMedicalRecord.deletMedicalRecrd(medicalrecords);
    }
}
