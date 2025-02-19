package Practice_Problems;
//Problem 7:

// Parse JSON and filter only those records where age > 25.

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper obj = new ObjectMapper();

        String jsonArray = "[{\"name\":\"Neha\",\"age\":22}," +
                "{\"name\":\"Arnav\",\"age\":26}," +
                "{\"name\":\"Adarsh\",\"age\":27}," +
                "{\"name\":\"Sahil\",\"age\":24}]";

        JsonNode root = obj.readTree(jsonArray);

        // Filtering and printing records where age > 25
        for (JsonNode node : root) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }
}
