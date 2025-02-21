package Bridgelabz_2113100011.Assignment21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteFile {

    public static void main(String[] args) {
       try(FileInputStream fis =new FileInputStream("D:\\Bridge\\Bridgelabz_2113100011\\Assignment21\\message.txt");
       FileOutputStream fos =new FileOutputStream("copy.txt")){

           int byteData;
           while((byteData=fis.read())!=-1){
               fos.write(byteData);
           }
           System.out.println("Files copied successfully");
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
    }
}
