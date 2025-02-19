package hands_on_practise_problems;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JSONtoXML {
    public static void main(String[] args) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        File jsonFile = new File("data.json");
        Object json = jsonMapper.readValue(jsonFile, Object.class);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        System.out.println(xml);
    }
}