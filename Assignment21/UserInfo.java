package Bridgelabz_2113100011.Assignment21;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInfo {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("userdata.txt")) {

            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            System.out.println("User information saved successfully!");



        } catch (IOException e) {
            System.out.println("Exception: " + e);

        }


    }
}
