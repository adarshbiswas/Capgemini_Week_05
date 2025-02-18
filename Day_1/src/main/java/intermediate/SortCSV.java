package intermediate;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String inputPath = "src/main/resources/employees.csv";   // Input CSV file path
        String outputPath = "src/main/resources/sorted_employees.csv";  // Output CSV file path

        try (CSVReader reader = new CSVReader(new FileReader(inputPath))) {
            List<String[]> records = new ArrayList<>();
            String[] nextLine;

            // Read the header
            String[] header = reader.readNext();
            records.add(header);  // Add header to the records list

            // Read the rest of the records
            while ((nextLine = reader.readNext()) != null) {
                records.add(nextLine);
            }

            // Sort records by Salary (assuming Salary is in index 3) in descending order
            Collections.sort(records.subList(1, records.size()), new Comparator<String[]>() { // Skip the header row
                @Override
                public int compare(String[] record1, String[] record2) {
                    double salary1 = Double.parseDouble(record1[3]);
                    double salary2 = Double.parseDouble(record2[3]);
                    return Double.compare(salary2, salary1); // Descending order
                }
            });

            // Save sorted records to a new CSV file
            try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {
                writer.writeAll(records);  // Write all records (including header)
            }

            // Print the top 5 highest-paid employees
            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 1; i <= 5 && i < records.size(); i++) { // Skip header row
                String[] record = records.get(i);
                System.out.println("ID = " + record[0] + ", Name = " + record[1] + ", Salary = " + record[3] + ", Department = " + record[4]);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace(); // Handle exceptions properly
        }
    }
}
