package in.vamsoft.day2collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListSort {
  
  /**
   * @param args.
   */
  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    list.add(12);
    list.add(56);
    list.add(89);
    list.add(72);
    list.add(85);
    list.add(26);
    list.add(81);
    list.add(70);
    list.add(81);
    
    Collections.sort(list);
    
    for (int a:list) {
      System.out.print(a + " ");
    }
  }

}
