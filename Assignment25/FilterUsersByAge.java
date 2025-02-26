package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterUsersByAge {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootArray = objectMapper.readTree(new File("users.json"));

        List<JsonNode> filteredUsers = new ArrayList<>();
        for (JsonNode node : rootArray) {
            if (node.get("age").asInt() > 25) {
                filteredUsers.add(node);
            }
        }

        String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers);
        System.out.println(filteredJson);
    }
}
