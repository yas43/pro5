package com.ykeshtdar.reader;

import com.fasterxml.jackson.databind.*;
import org.springframework.stereotype.Component;

import java.io.*;
@Component
public class JsonReaderFile {
    private static final ObjectMapper mapper = new ObjectMapper();

    public JsonNode JsonReaderFilePerson() throws IOException {
        InputStream Input =
                JsonReaderFile.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = mapper.readTree(Input);
        return rootNode.path("persons");

    }

    public JsonNode JsonReaderFileFireStation() throws IOException {
        InputStream Input =
                JsonReaderFile.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = mapper.readTree(Input);
        return rootNode.path("firestations");

    }

    public JsonNode JsonReaderFileMedicalRecords() throws IOException {
        InputStream Input =
                JsonReaderFile.class.getClassLoader()
                        .getResourceAsStream("data.json");

        JsonNode rootNode = mapper.readTree(Input);
        return rootNode.path("medicalrecords");

    }


    public JsonNode JsonReaderFileAll() throws IOException {
        InputStream Input =
                JsonReaderFile.class.getClassLoader()
                        .getResourceAsStream("data.json");

       return mapper.readTree(Input);


    }


}
