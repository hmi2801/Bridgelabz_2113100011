package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Student {
    public String name;
    public int age;
    public List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}

public class StudentJsonCreator {
    public static void main(String[] args) throws Exception {
        Student student = new Student("John Doe", 20, Arrays.asList("Math", "Science", "History"));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(jsonString);
    }
}
