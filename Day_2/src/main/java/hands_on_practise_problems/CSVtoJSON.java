package hands_on_practise_problems;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class CSVtoJSON {
    public static void main(String[] args) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.builder().setUseHeader(true).build();
        File csvFile = new File("data.csv");

        Object csvData = csvMapper.readerFor(Object.class).with(schema).readValue(csvFile);
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);
        System.out.println(json);
    }
}
