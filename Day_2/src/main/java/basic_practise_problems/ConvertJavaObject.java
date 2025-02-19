package Practice_Problems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
//Problem 2:
//Convert a Java object (Car) into JSON format.


public class ConvertJavaObject {
    public static void main(String[] args) throws Exception {
        ObjectMapper obj = new ObjectMapper();


        ObjectNode car = obj.createObjectNode();
        car.put("brand", "Toyota");
        car.put("model", "Corolla");
        car.put("year", 2022);

        String json = obj.writeValueAsString(car);
        System.out.println(json);
    }
}
