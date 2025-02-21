package Bridgelabz_2113100011.Assignment21;

import java.io.*;

public class ImageToByteArray {

    public static void main(String[] args) {
        String inputImagePath = "\"C:\\Users\\harsh\\OneDrive\\Desktop\\images.jpg\"";  // Change this to your image file
        String outputImagePath = "output.jpg";

        try {
            // Convert image to byte array
            byte[] imageBytes = convertImageToByteArray(inputImagePath);

            // Write byte array back to image file
            writeByteArrayToImage(imageBytes, outputImagePath);

            System.out.println("Image successfully copied from " + inputImagePath + " to " + outputImagePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to convert image to byte array
    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];  // Read in chunks of 4 KB
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray(); // Convert to byte array
        }
    }

    // Method to write byte array back to image
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // Write in chunks of 4 KB
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
