package hands_on_practise_problems;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

// Address class
 class Address {
    private String city;
    private String state;

    public Address() {
    };

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // Getters and setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

// User class
class User {
    private String name;
    private int age;
    private String email;
    private Address address;

    public User() {
    }

    ;

    //    Getters and setters
//    Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    Age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //    Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //    Address
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

public class ReadPrintJsonFile {
    public static void main(String[] args) {

        String jsonFilePath = "Day_2/src/main/resources/user.json";
        ObjectMapper mapper = new ObjectMapper();

        try {
            User user = mapper.readValue(new File(jsonFilePath), User.class);
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
