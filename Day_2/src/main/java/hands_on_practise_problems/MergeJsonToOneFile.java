package hands_on_practise_problems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonToOneFile {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json1 = mapper.createObjectNode();
        json1.put("name", "John");
        json1.put("age", 25);

        ObjectNode json2 = mapper.createObjectNode();
        json2.put("city", "New York");
        json2.put("country", "USA");

        // Merge json2 into json1
        json1.setAll(json2);

        String mergedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1);
        System.out.println(mergedJson);
    }
}