package Assignment5.Level1;

import java.util.Scanner;

public class CheckVoter {
    public static void main(String[] args) {
        int[] age=new int[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < 10; i++) {
            age[i]=sc.nextInt();
        }
        System.out.print("The student with age ");
        for (int i = 0; i < 10; i++) {
            if(age[i]>=18){
                System.out.print(age[i]+",");
            }
        }
        System.out.println(" can vote.");
        System.out.println();
        System.out.print("The student with age ");
        for (int i = 0; i < 10; i++) {
            if(age[i]<18){
                System.out.print(age[i]+",");
            }
        }
        System.out.println(" can not vote");

    }
}
