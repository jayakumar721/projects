package in.vamsoft.day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyStreams {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the source file to copy :");
    String source = sc.nextLine();
    System.out.println("Enter the Destination file :");
    String destination = sc.nextLine();
    sc.close();
    try (FileInputStream fis = new FileInputStream(source);FileOutputStream fos = new FileOutputStream(destination);) {
      
      int i = 0;
      while((i=fis.read()) != -1) {
        fos.write(i);
      }
      System.out.println("file copied successfull");
    
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
        
        
  }

}
