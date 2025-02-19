package Practice_Problems;
//Problem 5:

// Validate JSON structure using Jackson.

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"Neha\", \"age\": 21, \"email\": \"neha@gmail.com\" }";

        if (isValidJSON(jsonString)) {
            System.out.println("Valid JSON structure ");
        } else {
            System.out.println("Invalid JSON structure ");
        }
    }

    public static boolean isValidJSON(String json) {
        try {
            ObjectMapper obj = new ObjectMapper();
            JsonNode node = obj.readTree(json);
            return node.has("name") && node.has("age") && node.has("email");
        } catch (Exception e) {
            return false;
        }
    }

}
