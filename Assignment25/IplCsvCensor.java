package org.example;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IplCsvCensor {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("ipl_data.csv");
        File outputFile = new File("ipl_data_censored.csv");

        // Read CSV into List of Maps
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        List<Map<String, String>> matches = csvMapper.readerFor(Map.class).with(schema).readValues(inputFile).readAll();

        // Censor the data
        List<Map<String, String>> censoredMatches = matches.stream().map(match -> {
            match.put("team1", maskTeamName(match.get("team1")));
            match.put("team2", maskTeamName(match.get("team2")));
            match.put("winner", maskTeamName(match.get("winner")));
            match.put("player_of_match", "REDACTED");
            return match;
        }).collect(Collectors.toList());

        // Write back to CSV
        CsvSchema outputSchema = schema.withColumnSeparator(',');
        csvMapper.writer(outputSchema).writeValue(outputFile, censoredMatches);

        System.out.println("Censored CSV file generated: ipl_data_censored.csv");
    }

    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        return words[0] + " ***"; // Replace second part with ***
    }
}

