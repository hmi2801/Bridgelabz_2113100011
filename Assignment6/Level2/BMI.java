package Assignment6.Level2;

import java.util.Scanner;

public class BMI {

    public static double calculateBMI(double weight, double height) {
        height = height / 100;  // Convert cm to meters
        return weight / (height * height);
    }

    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi >= 18.5 && bmi < 24.9) return "Normal weight";
        else if (bmi >= 25 && bmi < 29.9) return "Overweight";
        else return "Obesity";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] bmiData = new double[10][3];

        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Weight (kg) for person " + (i+1) + ": ");
            bmiData[i][0] = scanner.nextDouble();
            System.out.print("Height (cm) for person " + (i+1) + ": ");
            bmiData[i][1] = scanner.nextDouble();
            bmiData[i][2] = calculateBMI(bmiData[i][0], bmiData[i][1]);
        }

        System.out.println("BMI and Status of all 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i+1) + " - BMI: " + bmiData[i][2] + ", Status: " + getBMIStatus(bmiData[i][2]));
        }
    }
}

