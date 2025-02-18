package advance;

import java.io.*;
import java.util.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Sahil Jain\\Desktop\\Training\\Week_05\\day_01\\src\\main\\resources\\largefile.csv"; // Path to your large CSV file
        int batchSize = 100; // Process 100 lines at a time
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> batch = new ArrayList<>();

            // Skip header
            String header = br.readLine();
            System.out.println("Header: " + header);

            while ((line = br.readLine()) != null) {
                batch.add(line);

                // Process batch when it reaches the limit
                if (batch.size() == batchSize) {
                    processBatch(batch);
                    totalRecords += batch.size();
                    batch.clear(); // Clear for next batch
                }
            }

            // Process remaining lines (if any)
            if (!batch.isEmpty()) {
                processBatch(batch);
                totalRecords += batch.size();
            }

            System.out.println("✅ Total records processed: " + totalRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Simulated batch processing
    private static void processBatch(List<String> batch) {
        System.out.println("Processing " + batch.size() + " records...");
        // You can modify this to store in a database, analyze data, etc.
    }
}
