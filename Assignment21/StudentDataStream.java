package Bridgelabz_2113100011.Assignment21;

import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "students.dat";

        // Writing Student Data
        writeStudentData(fileName);

        // Reading Student Data
        readStudentData(fileName);
    }

    public static void writeStudentData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Alice"); // Name
            dos.writeDouble(8.5); // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(7.8);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(9.2);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading student data from file:");

            while (dis.available() > 0) { // Read until end of file
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

