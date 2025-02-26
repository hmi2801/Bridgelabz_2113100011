package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.util.Set;

public class ValidateEmailField {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance();

        JsonNode jsonNode = objectMapper.readTree(new File("data.json"));
        JsonSchema schema = schemaFactory.getSchema(new File("schema.json"));

        Set<ValidationMessage> validationErrors = schema.validate(jsonNode);

        if (validationErrors.isEmpty()) {
            System.out.println("JSON is valid.");
        } else {
            for (ValidationMessage error : validationErrors) {
                System.out.println("Validation error: " + error.getMessage());
            }
        }
    }
}
