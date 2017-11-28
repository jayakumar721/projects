package in.vamsoft.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamsInputDemo {
  private static String name;
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    try {
      do {
        System.out.println("Enter any String :");
        name = reader.readLine();
        System.out.println("you entered :" + name);

      } while (!name.equals("quit"));
      reader.close();

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
