package Assignment6;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter Rate: ");
        double rate = scanner.nextDouble();
        System.out.print("Enter Time: ");
        double time = scanner.nextDouble();
        double simpleInterest = principal * rate * time / 100;
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }
}
