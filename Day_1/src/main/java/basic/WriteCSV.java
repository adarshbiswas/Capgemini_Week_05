package basic;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

/*Write Data to a CSV File
Create a CSV file with employee details (ID, Name, Department, Salary).
Write at least 5 records to the file
*/
public class WriteCSV {
    public static void main(String[] args) {
        String fileName = "src\\main\\resources\\Sahil.csv";
       try (CSVWriter writer = new CSVWriter(new FileWriter(fileName,true));){
           String [] header = {"ID","Name","Age","Salary"};
           String [] row1 ={"1","John Doe","30","50000"};
           String[] row2 ={"2","Jane Smith","28","55000"};
           String[] row3 ={"3","David Johnson","35","60000"};
           writer.writeNext(header);
           writer.writeNext(row1);
           writer.writeNext(row2);
           writer.writeNext(row3);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}
