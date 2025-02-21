package Bridgelabz_2113100011.Assignment21;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Replace with your actual file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) { // Read line by line
                if (line.toLowerCase().contains("error")) { // Case insensitive check
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
