package advance;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String path = "C:\\Users\\Sahil Jain\\Desktop\\Training\\Week_05\\day_01\\src\\main\\resources\\employees.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String[]> duplicateRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];

                if (!uniqueIds.add(id)) { // If ID is already in the set, it's a duplicate
                    duplicateRecords.add(nextLine);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        // Print duplicate records
        if (!duplicateRecords.isEmpty()) {
            System.out.println("🚨 Duplicate Records Found:");
            for (String[] record : duplicateRecords) {
                System.out.println(Arrays.toString(record));
            }
        } else {
            System.out.println("✅ No duplicate records found!");
        }
    }
}
