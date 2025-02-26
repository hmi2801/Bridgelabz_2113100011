package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode json1 = objectMapper.createObjectNode();
        json1.put("name", "John Doe");
        json1.put("age", 30);

        ObjectNode json2 = objectMapper.createObjectNode();
        json2.put("email", "johndoe@example.com");
        json2.put("city", "New York");

        json1.setAll(json2);

        String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1);
        System.out.println(mergedJson);
    }
}

