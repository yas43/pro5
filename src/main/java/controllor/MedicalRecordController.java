package controllor;



import model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import service.*;

import java.io.*;

@RestController
public class MedicalRecordController {
    @Autowired
    PostMedicalRecord postMedicalRecord;
    @Autowired
    UpdateMedicalRecord updateMedicalRecord;
    @Autowired
    DeleteMedicalRecord deleteMedicalRecord;

    @PostMapping("http://localhost:8080/medicalRecord/{medicalrecord}")
    @ResponseBody
    public void addMedicalRecord(@PathVariable("medicalrecord") Medicalrecords medicalrecords) throws IOException {
//        PostMedicalRecord postMedicalRecord = new PostMedicalRecord();
        postMedicalRecord.addMedicalRecords(medicalrecords);
    }

    @PutMapping("http://localhost:8080/medicalRecord/{medicalrecord}")
    @ResponseBody
    public void updateExistingFireStation(@PathVariable("medicalrecord") Medicalrecords medicalrecords) throws IOException {
//        UpdateMedicalRecord updateMedicalRecord = new UpdateMedicalRecord();
        updateMedicalRecord.updatMedicalRecords(medicalrecords);
    }

    @DeleteMapping("http://localhost:8080/medicalRecord/{medicalrecord}")
    @ResponseBody
    public void removeExistingMedicalRecord(@PathVariable("medicalrecord") Medicalrecords medicalrecords) throws IOException {
//        DeleteMedicalRecord deleteMedicalRecord = new DeleteMedicalRecord();
        deleteMedicalRecord.deletMedicalRecrd(medicalrecords);
    }
}
