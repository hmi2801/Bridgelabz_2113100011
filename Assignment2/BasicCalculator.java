package Assignment2;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        System.out.println("The addition is " + (num1 + num2) + ", subtraction is " + (num1 - num2) +
                ", multiplication is " + (num1 * num2) + " and division is " + (num1 / num2));
    }
}

