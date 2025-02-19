package hands_on_practise_problems;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

// Car class
class Car {
    private String make;
    private String model;
    private int year;

    public Car() {
    }

    ;

    // Constructors, getters, and setters
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Add getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class JavaObjectsToJsonArray {
    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                new Car("Toyota", "Corolla", 2020),
                new Car("Honda", "Civic", 2019)
        );

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);
            System.out.println(jsonArray);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}