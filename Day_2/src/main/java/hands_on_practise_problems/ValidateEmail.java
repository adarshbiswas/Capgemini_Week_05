package hands_on_practise_problems;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ValidateEmail {
    public static void main(String[] args) {
        String schemaJson = "{\"type\":\"object\",\"properties\":{\"email\":{\"type\":\"string\",\"format\":\"email\"}}}";
        String jsonData = "{\"email\":\"invalid-email\"}";

        JSONObject schema = new JSONObject(new JSONTokener(schemaJson));
        JSONObject data = new JSONObject(new JSONTokener(jsonData));

        Schema schemaValidator = SchemaLoader.load(schema);
        try {
            schemaValidator.validate(data);
            System.out.println("Email is valid.");
        } catch (ValidationException e) {
            System.out.println("Invalid email: " + e.getMessage());
        }
    }
}
