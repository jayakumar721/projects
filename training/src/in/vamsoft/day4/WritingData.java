package in.vamsoft.day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WritingData {

  public static void main(String[] args) {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fReader = new BufferedReader(new FileReader("tex.txt"));
        BufferedWriter fwriter = new BufferedWriter(new FileWriter("tex.txt",true));) {
      
      System.out.println("Enter the name :");
      String name = reader.readLine();
      fwriter.write("Name:" + name);
      fwriter.newLine();
      System.out.println("Enter your age :");
      String age = reader.readLine();
      fwriter.write("Age :" + age);
      fwriter.newLine();
      reader.close();
      fwriter.close();
      
      String empty = "";
     
      
      while ((empty = fReader.readLine()) != null) {
        System.out.println(empty);
      }
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
