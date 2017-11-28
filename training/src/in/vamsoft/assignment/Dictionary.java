package in.vamsoft.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
  
  /**
   * @param args.
   */
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("recursive", "relating to or involving a program");
    map.put("sort", "a category of things or people with a common feature");
    map.put("tackle", "the equipment required for a task or sport");
    System.out.println("Enter a word :");
    Scanner sc = new Scanner(System.in);
    String word = sc.nextLine();
    if (map.containsKey(word)) {
      
      System.out.println(word + " means :  " + map.get(word));
    } else {
      System.out.println("Invalid word!!");
    }
    sc.close();

  }

}
