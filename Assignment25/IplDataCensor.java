package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IplDataCensor {
    public static void main(String[] args) throws Exception {
        censorJson("ipl_data.json", "ipl_data_censored.json");
        censorCsv("ipl_data.csv", "ipl_data_censored.csv");
    }

    public static void censorJson(String inputFile, String outputFile) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootArray = objectMapper.readTree(new File(inputFile));

        for (JsonNode match : rootArray) {
            ((com.fasterxml.jackson.databind.node.ObjectNode) match).put("team1", maskTeamName(match.get("team1").asText()));
            ((com.fasterxml.jackson.databind.node.ObjectNode) match).put("team2", maskTeamName(match.get("team2").asText()));

            JsonNode scoreNode = match.get("score");
            Iterator<Map.Entry<String, JsonNode>> fields = scoreNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String maskedKey = maskTeamName(field.getKey());
                ((com.fasterxml.jackson.databind.node.ObjectNode) scoreNode).set(maskedKey, field.getValue());
                ((com.fasterxml.jackson.databind.node.ObjectNode) scoreNode).remove(field.getKey());
            }

            ((com.fasterxml.jackson.databind.node.ObjectNode) match).put("winner", maskTeamName(match.get("winner").asText()));
            ((com.fasterxml.jackson.databind.node.ObjectNode) match).put("player_of_match", "REDACTED");
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), rootArray);
        System.out.println("Censored JSON file generated: " + outputFile);
    }

    public static void censorCsv(String inputFile, String outputFile) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        List<Map<String, String>> matches = csvMapper.readerFor(Map.class).with(schema).readValues(new File(inputFile)).readAll();

        List<Map<String, String>> censoredMatches = matches.stream().map(match -> {
            match.put("team1", maskTeamName(match.get("team1")));
            match.put("team2", maskTeamName(match.get("team2")));
            match.put("winner", maskTeamName(match.get("winner")));
            match.put("player_of_match", "REDACTED");
            return match;
        }).collect(Collectors.toList());

        CsvSchema outputSchema = schema.withColumnSeparator(',');
        csvMapper.writer(outputSchema).writeValue(new File(outputFile), censoredMatches);

        System.out.println("Censored CSV file generated: " + outputFile);
    }

    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        return words[0] + " ***";
    }
}
