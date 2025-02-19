package Practice_Problems;
//Problem 4:

//Merge two JSON objects into one.

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeTwoJSONObject {
    public static void main(String[] args) throws Exception {
        ObjectMapper obj = new ObjectMapper();

        ObjectNode json1 = obj.createObjectNode();
        json1.put("name", "Neha");
        json1.put("age", 21);

        ObjectNode json2 = obj.createObjectNode();
        json2.put("email", "neha@gmail.com");
        json2.put("city", "Bhopal");

        json1.setAll(json2);

        String mergedJson = obj.writeValueAsString(json1);
        System.out.println(mergedJson);

    }
}
