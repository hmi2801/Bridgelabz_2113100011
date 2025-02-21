package Bridgelabz_2113100011.Assignment21;

import java.io.FileReader;
import java.io.FileWriter;

public class UpperCaseToLowerCase {

    public static void main(String[] args) {
        String file = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment21\\upperlower.txt";
        try (FileReader fr = new FileReader(file);
             FileWriter fw = new FileWriter("newfile.txt")) {

            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(Character.toLowerCase((char) ch));
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
