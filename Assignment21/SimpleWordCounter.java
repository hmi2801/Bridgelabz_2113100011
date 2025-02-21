package Bridgelabz_2113100011.Assignment21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SimpleWordCounter {

    public static void main(String[] args) {
        String filePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment21\\countwordfile.txt"; // Change this to your file path
        HashMap<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-z]", ""); // Remove non-letter characters
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print first 5 words from the HashMap (not necessarily top 5 by frequency)
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            count++;
            if (count == 5) break;
        }
    }


}
