package advance;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateLargeCSV {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("largefile.csv");

        // Writing header
        fileWriter.append("ID,Name,Age,Salary,Department,Email,Phone Number\n");

        Random random = new Random();
        String[] departments = {"Engineering", "Marketing", "HR", "Finance", "Sales"};

        // Generating 500,000 records (adjust based on required file size)
        for (int i = 1; i <= 500000; i++) {
            String name = "Name" + i;
            int age = random.nextInt(50) + 20;
            int salary = random.nextInt(30000) + 30000;
            String department = departments[random.nextInt(departments.length)];
            String email = "user" + i + "@example.com";
            String phone = String.format("%010d", random.nextLong());

            fileWriter.append(i + "," + name + "," + age + "," + salary + "," + department + "," + email + "," + phone + "\n");
        }

        fileWriter.close();
        System.out.println("Large CSV file generated successfully!");
    }
}
