package in.vamsoft.trainingday2;

import java.util.Collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author vamsoft .
 *
 */
class ComparatorSet implements Comparator<EmployeeSet> {

  @Override
  public int compare(EmployeeSet o1, EmployeeSet o2) {
    if (o1.getSalary() < o2.getSalary()) {
      return -1;
    } else if (o1.getSalary() > o2.getSalary()) {
      return 1;
    } else {
      return 0;
    }
  }
  
}


public class SetDemo {
  
  /**
   * @param args .
   */
  public static void main(String[] args) {
    
    List<EmployeeSet> empSet = new LinkedList<>();
    EmployeeSet e1 = new EmployeeSet(1, "a", 25000, 18);
    EmployeeSet e2 = new EmployeeSet(4, "r", 15000, 38);
    EmployeeSet e3 = new EmployeeSet(2, "w", 75000, 34);
    EmployeeSet e4 = new EmployeeSet(3, "f", 55000, 22);
  
    empSet.add(e1);
    empSet.add(e2);
    empSet.add(e3);
    empSet.add(e4);
    
    Collections.sort(empSet,new ComparatorSet());
    
    for (EmployeeSet a:empSet) {
      System.out.println(a);
    }
  }
  
  

}
