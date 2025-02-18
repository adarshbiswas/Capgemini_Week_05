package intermediate;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyCSV {
    public static void main(String[] args) {
        String inputPath = "src/main/resources/employees.csv";   // Input CSV file
        String outputPath = "src/main/resources/updated_employees.csv"; // Output CSV file

        try (CSVReader reader = new CSVReader(new FileReader(inputPath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {

            String[] nextLine;
            // Read the header and write it to the new file
            String[] header = reader.readNext();
            writer.writeNext(header);

            while ((nextLine = reader.readNext()) != null) {
                // Assuming Department is in the 5th column (index 4) and Salary is in the 4th column (index 3)
                if ("Engineering".equals(nextLine[4])) { // Modify this if needed
                    // Increase salary by 10%
                    double salary = Double.parseDouble(nextLine[3]);
                    salary += salary * 0.10;
                    nextLine[3] = String.valueOf(salary); // Update salary in the array
                }
                writer.writeNext(nextLine); // Write the updated record to the new CSV file
            }
            System.out.println("CSV file updated successfully!");

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace(); // Handle exceptions properly
        }
    }
}
