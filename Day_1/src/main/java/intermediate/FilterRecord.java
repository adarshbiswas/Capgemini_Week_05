package intermediate;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

/*4️⃣ Filter Records from CSV
Read a CSV file and filter students who have scored more than 80 marks.
Print only the qualifying records.
*/
public class FilterRecord {
    public static void main(String[] args) {
        String path = "src\\main\\resources\\student.csv";
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                if (Integer.parseInt(nextLine[5]) > 80) {
                    System.out.println("ID = " + nextLine[0] + " Name = " + nextLine[1] + " Age = " + nextLine[2] + " Grade = " + nextLine[3] + " Major = " + nextLine[4] + " Marks = " + nextLine[5]);

                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
