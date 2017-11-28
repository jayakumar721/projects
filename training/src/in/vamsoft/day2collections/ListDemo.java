package in.vamsoft.day2collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
  
  /**
   * @param args .
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
    for (int i:list) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i = 0;i < list.size();i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
    System.out.println(list.subList(3, 5));
    System.out.println();
   
    Iterator<Integer> listIterator = list.listIterator();
    while (listIterator.hasNext()) {
      System.out.print(listIterator.next() + " ");
    }

  }

}
