package Practice_Problems;
//Problem 1:

// Create a JSON object for a Student with fields: name, age, and subjects (array).

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateJSONObject {
    public static void main(String[] args) throws Exception {
        ObjectMapper obj = new ObjectMapper();

        ObjectNode student = obj.createObjectNode();
        student.put("name", "Neha");
        student.put("age", 18);
        student.putArray("subjects").add("Math").add("Science").add("English");

        String json = obj.writeValueAsString(student);
        System.out.println(json);
    }
}
