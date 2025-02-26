package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Employee {
    public String name;
    public int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonArrayConverter {
    public static void main(String[] args) throws Exception {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30),
                new Employee("Bob", 25)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        System.out.println(jsonArray);
    }
}
