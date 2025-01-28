package Assignment6;

import java.util.Scanner;

public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        System.out.println("Sine: " + sine + ", Cosine: " + cosine + ", Tangent: " + tangent);
    }
}

