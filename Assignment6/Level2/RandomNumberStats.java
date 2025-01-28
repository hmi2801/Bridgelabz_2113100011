package Assignment6.Level2;

import java.util.Random;

public class RandomNumberStats {

    public static int[] generate4DigitRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = 1000 + random.nextInt(9000); // Generate 4-digit number
        }

        return array;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = sum / (double) numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        double[] stats = findAverageMinMax(randomNumbers);

        System.out.println("Generated numbers: ");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nAverage: " + stats[0]);
        System.out.println("Minimum: " + stats[1]);
        System.out.println("Maximum: " + stats[2]);
    }
}

