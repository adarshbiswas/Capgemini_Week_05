package advance;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;


public class ValidateCSV {
    public static void main(String[] args) {
        String path = "src\\main\\resources\\employees.csv";

        // Define the regex pattern for validating email
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Define the regex pattern for validating phone number (10 digits)
        String phonePattern = "^[0-9]{10}$";

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] nextLine;
            reader.readNext();  // Skip header

            while ((nextLine = reader.readNext()) != null) {
                // Validate Email
                String email = nextLine[5];  // Assuming email is in column 5
                boolean isValidEmail = Pattern.matches(emailPattern, email);

                // Validate Phone Number
                String phoneNumber = nextLine[6];  // Assuming phone number is in column 6
                boolean isValidPhone = Pattern.matches(phonePattern, phoneNumber);

                // Print invalid records
                if (!isValidEmail || !isValidPhone) {
                    System.out.println("Invalid record: " +
                            "ID = " + nextLine[0] +
                            ", Name = " + nextLine[1] +
                            ", Email = " + email +
                            ", Phone = " + phoneNumber +
                            ", Department = " + nextLine[4]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
