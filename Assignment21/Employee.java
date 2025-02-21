package Bridgelabz_2113100011.Assignment21;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class implementing Serializable
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Override toString() to display employee details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

class EmployeeSerialization {
    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // Taking user input
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // Consume newline

            employees.add(new Employee(id, name, department, salary));
        }

        // Serialize employees list
        serializeEmployees(employees);

        // Deserialize and display employees
        deserializeEmployees();
    }

    // Method to serialize (save) employee list to a file
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully.\n");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    // Method to deserialize (load) employees from a file
    private static void deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            System.out.println("Employees retrieved from file:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
