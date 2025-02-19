package hands_on_practise_problems;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class FilterJsonData {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String filePath = "Day_2/src/main/resources/students.json";
        JsonNode root = mapper.readTree(new File(filePath));

        root.forEach(student -> {
            if (student.get("age").asInt() > 25) {
                System.out.println(student);
            }
        });
    }
}