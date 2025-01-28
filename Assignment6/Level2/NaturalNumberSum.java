package Assignment6.Level2;

import java.util.Scanner;

public class NaturalNumberSum {

    public static int sumRecursively(int n) {
        if (n == 1) return 1;
        return n + sumRecursively(n - 1);
    }

    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        System.out.println("Sum using recursion: " + sumRecursively(n));
        System.out.println("Sum using formula: " + sumFormula(n));
    }
}

