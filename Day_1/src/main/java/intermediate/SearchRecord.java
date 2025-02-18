package intermediate;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) {
        String path = "src\\main\\resources\\employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine[1].equals("Sahil Jain")) {
                    System.out.println("ID = " + nextLine[0] +
                            " Department = " + nextLine[4]);

                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
