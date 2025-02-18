package basic;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        String path = "src\\main\\resources\\employees.csv";
        int count=0;
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String [] nextLine;
            while((nextLine=reader.readNext())!=null){
                count++;
             }
            System.out.println("Count : " + count) ;
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
