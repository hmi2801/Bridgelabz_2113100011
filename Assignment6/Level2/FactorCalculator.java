package Assignment6.Level2;

import java.util.Scanner;

public class FactorCalculator {

    public static int[] findFactors(int num) {
        int count = 0;

        // Count factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;

        // Store factors in the array
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors[index++] = i;
        }

        return factors;
    }

    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int sumOfSquares(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }

    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int[] factors = findFactors(num);

        System.out.println("Factors of " + num + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        System.out.println("\nSum of factors: " + sumFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
    }
}

