package in.vamsoft.bank;

import java.io.FileReader;
import java.io.FileWriter;

public class FileRead {

  public static void main(String[] args) {
    try {
      FileReader fileReader = new FileReader("te.txt");
      FileWriter fileWriter;
      while (fileReader.read() != -1) {
        System.out.println(fileReader.read());
      }
      //fileWriter.append("Asd");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
