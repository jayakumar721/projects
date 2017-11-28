package in.vamsoft.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileToFile {

  public static void main(String[] args) {
    try {
      FileReader reader = new FileReader("te.txt");
      FileWriter writer = new FileWriter("te1.txt");
      BufferedReader bufferedReader = new BufferedReader(reader);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);
      while (bufferedReader.readLine() != null) {
        bufferedWriter.write(bufferedReader.readLine());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
