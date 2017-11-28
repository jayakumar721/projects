package in.vamsoft.day4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MarkMethod {
  
  public static void main(String[] args) {
    try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("text.txt"), 1);){
      System.out.println("data are");
      System.out.println((char)inputStream.read());
      System.out.println((char)inputStream.read());
      System.out.println((char)inputStream.read());
      inputStream.mark(10);
      System.out.println("mark invoked");
      System.out.println((char)inputStream.read());
      System.out.println((char)inputStream.read());
      System.out.println((char)inputStream.read());
      System.out.println((char)inputStream.read());
      System.out.println((char)inputStream.read());
      System.out.println((char)inputStream.read());
      if(inputStream.markSupported()) {
        inputStream.reset();
        System.out.println("reset invoked");
        System.out.println((char)inputStream.read());
        System.out.println((char)inputStream.read());
        System.out.println((char)inputStream.read());
      } else {
        System.out.println((char)inputStream.read());
        System.out.println((char)inputStream.read());
        System.out.println((char)inputStream.read());
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
