package Practice_Problems;
//Problem 6:

// Convert a list of Java objects into a JSON array.

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvertListIntoJSONArray {
    public static void main(String[] args) throws Exception {
        ObjectMapper obj = new ObjectMapper();

        List<String> names = List.of("Neha", "Arnav", "Adarsh", "Sahil");

        String json = obj.writeValueAsString(names);
        System.out.println(json);
    }
}
