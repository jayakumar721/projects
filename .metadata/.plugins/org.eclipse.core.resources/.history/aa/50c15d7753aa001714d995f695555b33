package in.vamsoft.training.general;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SampleCsv {
  /**
   * @param args .
   */
  public static void main(String[] args) {
    String fileName = "data.csv";
    File file = new File(fileName);
    Scanner in;
    try {
      in = new Scanner(file);
      in.nextLine();
      while (in.hasNext()) {
        String data = in.next();
        String[] values = data.split(",");
        System.out.println(values[0]);
      }
      in.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  
  }

}
