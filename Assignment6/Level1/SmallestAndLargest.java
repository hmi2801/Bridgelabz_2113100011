    package Assignment6;

    import java.util.Scanner;

    public class SmallestAndLargest {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            System.out.print("Enter third number: ");
            int num3 = scanner.nextInt();
            int smallest = Math.min(num1, Math.min(num2, num3));
            int largest = Math.max(num1, Math.max(num2, num3));
            System.out.println("Smallest: " + smallest + ", Largest: " + largest);
        }
    }

