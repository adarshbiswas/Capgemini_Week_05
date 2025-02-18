package basic;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*1️⃣ Read a CSV File and Print Data
Read a CSV file containing student details (ID, Name, Age, Marks).
Print each record in a structured format.
*/
public class ReadCSV {
    public static void main(String[] args) {
        String path = "src\\main\\resources\\employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String [] nextLine;
            nextLine=reader.readNext();
            while((nextLine=reader.readNext())!=null){
                System.out.println("ID = " + nextLine[0] + " Name = " + nextLine[1] +" Age = "+nextLine[2] + " Salary = "+nextLine[3] + " Department = " + nextLine[4]  );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
