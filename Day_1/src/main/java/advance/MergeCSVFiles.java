package advance;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {

    public static void main(String[] args) {
        String students1Path = "C:\\Users\\Sahil Jain\\Desktop\\Training\\Week_05\\day_01\\src\\main\\resources\\students1.csv";
        String students2Path = "C:\\Users\\Sahil Jain\\Desktop\\Training\\Week_05\\day_01\\src\\main\\resources\\students2.csv";
        String outputPath = "C:\\Users\\Sahil Jain\\Desktop\\Training\\Week_05\\day_01\\src\\main\\resources\\merged_students.csv";


        try (
                CSVReader reader1 = new CSVReader(new FileReader(students1Path));
                CSVReader reader2 = new CSVReader(new FileReader(students2Path));
                CSVWriter writer = new CSVWriter(new FileWriter(outputPath))
        ) {
            // Read the header from students1.csv
            String[] header1 = reader1.readNext();
            String[] header2 = reader2.readNext();

            // Create a map to store the data from students2.csv
            Map<String, String[]> student2Data = new HashMap<>();

            // Read students2.csv and store its data in the map based on ID
            String[] nextLine;
            while ((nextLine = reader2.readNext()) != null) {
                student2Data.put(nextLine[0], nextLine); // Key: ID, Value: the entire record from students2.csv
            }

            // Write the merged header
            String[] mergedHeader = new String[]{
                    "ID", "Name", "Age", "Marks", "Grade"
            };
            writer.writeNext(mergedHeader);

            // Read students1.csv, merge with students2.csv, and write to the new file
            while ((nextLine = reader1.readNext()) != null) {
                String id = nextLine[0];
                String name = nextLine[1];
                String age = nextLine[2];

                // Retrieve the corresponding data from students2.csv
                String[] student2 = student2Data.get(id);
                if (student2 != null) {
                    String marks = student2[1];
                    String grade = student2[2];

                    // Write the merged record to the new file
                    String[] mergedRecord = new String[]{id, name, age, marks, grade};
                    writer.writeNext(mergedRecord);
                }
            }

            System.out.println("CSV files merged successfully.");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
