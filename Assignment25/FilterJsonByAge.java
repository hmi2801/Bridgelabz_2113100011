package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonByAge {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootArray = objectMapper.readTree(new File("people.json"));

        List<JsonNode> filteredRecords = new ArrayList<>();
        for (JsonNode node : rootArray) {
            if (node.get("age").asInt() > 25) {
                filteredRecords.add(node);
            }
        }

        String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredRecords);
        System.out.println(filteredJson);
    }
}
