package Assignment6;

import java.util.Scanner;

public class ChocolatesDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int chocolates = scanner.nextInt();
        System.out.print("Enter number of children: ");
        int children = scanner.nextInt();
        int chocolatesPerChild = chocolates / children;
        int remainingChocolates = chocolates % children;
        System.out.println("Each child gets " + chocolatesPerChild + " chocolates, " + remainingChocolates + " remaining.");
    }
}

