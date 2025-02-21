package Bridgelabz_2113100011.Assignment21;

import java.io.*;

public class StreamComparison {

    public static void bufferedStream() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Bridge\\Bridgelabz_2113100011\\Assignment21\\LargeFile.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("largefilecopy1.txt"))) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush(); // Ensure data is written
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fileStream() {
        try (FileInputStream fis = new FileInputStream("D:\\Bridge\\Bridgelabz_2113100011\\Assignment21\\LargeFile.txt");
             FileOutputStream fos = new FileOutputStream("largefilecopy2.txt")) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Files copied successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        long startTime, endTime;

        startTime = System.nanoTime();
        bufferedStream();
        endTime = System.nanoTime();
        System.out.println("Elapsed time for BufferedStream: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        fileStream();
        endTime = System.nanoTime();
        System.out.println("Elapsed time for FileStream: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
