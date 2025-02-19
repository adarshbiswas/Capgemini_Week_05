package Practice_Problems;
//Problem 3:

//Read a JSON file and extract only specific fields (e.g., name, email).

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJSONFile {
    public static void main(String[] args) throws Exception {
        ObjectMapper obj = new ObjectMapper();

        // Read JSON file
        JsonNode root = obj.readTree(new File("Day_02/src/main/resources/data.json"));

        // Extract specific fields
        String name = root.get("name").asText();
        String email = root.get("email").asText();

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
