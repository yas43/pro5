package com.ykeshtdar.P5.reader;

import com.fasterxml.jackson.databind.*;

import java.io.*;

public class JsonReaderFile {
    private static ObjectMapper mapper = new ObjectMapper();

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

        JsonNode rootNode = mapper.readTree(Input);
        return rootNode;

    }


}
