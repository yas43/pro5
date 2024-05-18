package service;




import dto.*;
import reader.*;

import java.io.*;
import java.util.*;

public class NumerosTelephoneParCaserneService {
    JsonReaderFile jsonReaderFile = new JsonReaderFile();
    Set<NumerosTelephoneParCaserne> numerosTelephoneParCaserneList = new HashSet<>();

    public Set<NumerosTelephoneParCaserne> phoneNumbers(int firesationnumber) throws IOException {
        String firestationstring = String.valueOf(firesationnumber);
        for (int i = 0; i < jsonReaderFile.JsonReaderFileFireStation().size(); i++) {
            if (jsonReaderFile.JsonReaderFileFireStation().path(i).path("station").asText().equals(firestationstring)) {
                for (int j = 0; j < jsonReaderFile.JsonReaderFilePerson().size(); j++) {
                    NumerosTelephoneParCaserne numerosTelephoneParCaserne = new NumerosTelephoneParCaserne();
                    if (jsonReaderFile.JsonReaderFilePerson().path(j).path("address").equals(jsonReaderFile.JsonReaderFileFireStation().path(i).path("address"))) {
                        numerosTelephoneParCaserne.setPhoneNumber(jsonReaderFile.JsonReaderFilePerson().path(j).path("phone").asText());
                        numerosTelephoneParCaserneList.add(numerosTelephoneParCaserne);
                    }
                }
            }
        }
        return numerosTelephoneParCaserneList;
    }
}
