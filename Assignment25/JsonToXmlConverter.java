package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class JsonToXmlConverter {
    public static void main(String[] args) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        JsonNode jsonNode = jsonMapper.readTree(new File("data.json"));
        String xmlString = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        System.out.println(xmlString);
    }
}

