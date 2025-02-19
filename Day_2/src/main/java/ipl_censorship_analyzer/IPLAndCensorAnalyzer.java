package ipl_censorship_analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class IPLAndCensorAnalyzer {

    // Requirement 1: Input Data Formats
    // JSON and CSV input files
    private static final String JSON_INPUT_FILE = "input.json";
    private static final String CSV_INPUT_FILE = "input.csv";
    private static final String JSON_OUTPUT_FILE = "output.json";
    private static final String CSV_OUTPUT_FILE = "output.csv";

    // Requirement 2: Censorship Rules
    // Mask team names by replacing part of the name with "***"
    private static String maskTeamName(String teamName) {
        if (teamName == null || teamName.isEmpty()) {
            return teamName;
        }
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        return teamName;
    }

    // Redact player of the match by replacing the name with "REDACTED"
    private static String redactPlayerOfMatch(String playerName) {
        return "REDACTED";
    }

    // Requirement 3: Output Data Formats
    // Process JSON data
    private static void processJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty print JSON

        // Read JSON input
        File inputFile = new File(JSON_INPUT_FILE);
        List<Map<String, Object>> matches = mapper.readValue(inputFile, List.class);

        // Apply censorship rules
        for (Map<String, Object> match : matches) {
            match.put("team1", maskTeamName((String) match.get("team1")));
            match.put("team2", maskTeamName((String) match.get("team2")));
            match.put("winner", maskTeamName((String) match.get("winner")));
            match.put("player_of_match", redactPlayerOfMatch((String) match.get("player_of_match")));
        }

        // Write censored JSON output
        File outputFile = new File(JSON_OUTPUT_FILE);
        mapper.writeValue(outputFile, matches);
        System.out.println("Censored JSON data saved to: " + JSON_OUTPUT_FILE);
    }

    // Process CSV data
    private static void processCSV() throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_INPUT_FILE));
             CSVWriter writer = new CSVWriter(new FileWriter(CSV_OUTPUT_FILE))) {

            // Read CSV input
            List<String[]> records = reader.readAll();

            // Apply censorship rules
            for (String[] record : records) {
                if (!record[0].equals("match_id")) { // Skip header
                    record[1] = maskTeamName(record[1]); // team1
                    record[2] = maskTeamName(record[2]); // team2
                    record[5] = maskTeamName(record[5]); // winner
                    record[6] = redactPlayerOfMatch(record[6]); // player_of_match
                }
            }

            // Write censored CSV output
            writer.writeAll(records);
            System.out.println("Censored CSV data saved to: " + CSV_OUTPUT_FILE);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        try {
            // Process JSON data
            processJSON();

            // Process CSV data
            processCSV();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}