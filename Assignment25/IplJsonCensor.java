package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class IplJsonCensor {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootArray = objectMapper.readTree(new File("ipl_data.json"));

        for (JsonNode match : rootArray) {
            // Mask team names
            String team1 = match.get("team1").asText();
            String team2 = match.get("team2").asText();
            ((com.fasterxml.jackson.databind.node.ObjectNode) match).put("team1", maskTeamName(team1));
            ((com.fasterxml.jackson.databind.node.ObjectNode) match).put("team2", maskTeamName(team2));

            // Mask score keys
            JsonNode scoreNode = match.get("score");
            Iterator<Map.Entry<String, JsonNode>> fields = scoreNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String maskedKey = maskTeamName(field.getKey());
                ((com.fasterxml.jackson.databind.node.ObjectNode) scoreNode).set(maskedKey, field.getValue());
                ((com.fasterxml.jackson.databind.node.ObjectNode) scoreNode).remove(field.getKey());
            }

            // Mask winner
            String winner = match.get("winner").asText();
            ((com.fasterxml.jackson.databind.node.ObjectNode) match).put("winner", maskTeamName(winner));

            // Redact player of the match
            ((com.fasterxml.jackson.databind.node.ObjectNode) match).put("player_of_match", "REDACTED");
        }

        // Write the censored JSON data back to file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("ipl_data_censored.json"), rootArray);
        System.out.println("Censored JSON file generated: ipl_data_censored.json");
    }

    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        return words[0] + " ***"; // Replace second part with ***
    }
}
