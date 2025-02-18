package advance;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String id;
    private String name;
    private String age;
    private String grade;
    private String major;
    private String marks;

    // Constructor
    public Student(String id, String name, String age, String grade, String major, String marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
        this.marks = marks;
    }

    // Getters and Setters (optional)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    // Override toString() to print the student details
    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age='" + age + '\'' + ", grade='" + grade + '\'' + ", major='" + major + '\'' + ", marks='" + marks + '\'' + '}';
    }
}


public class CSVToJavaObjects {

    public static void main(String[] args) {
        String path = "src\\main\\resources\\student.csv"; // Update the path to your CSV file
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] nextLine;
            reader.readNext();  // Skip the header row

            // Read the rest of the rows and map them to Student objects
            while ((nextLine = reader.readNext()) != null) {
                // Create a Student object for each row
                Student student = new Student(nextLine[0],  // ID
                        nextLine[1],  // Name
                        nextLine[2],  // Age
                        nextLine[3],  // Grade
                        nextLine[4],  // Major
                        nextLine[5]   // Marks
                );
                // Add the Student object to the list
                students.add(student);
            }

            // Print all the students
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

