package Assignment6.Level2;

import java.util.Scanner;

public class YoungestTallestFriend {

    public static int findYoungest(int[] ages) {
        int minAge = ages[0];
        for (int age : ages) {
            if (age < minAge) minAge = age;
        }
        return minAge;
    }

    public static int findTallest(int[] heights) {
        int maxHeight = heights[0];
        for (int height : heights) {
            if (height > maxHeight) maxHeight = height;
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];

        System.out.println("Enter ages and heights for Amar, Akbar, and Anthony:");

        for (int i = 0; i < 3; i++) {
            System.out.print("Age of friend " + (i+1) + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Height of friend " + (i+1) + ": ");
            heights[i] = scanner.nextInt();
        }

        System.out.println("Youngest age: " + findYoungest(ages));
        System.out.println("Tallest height: " + findTallest(heights));
    }
}
