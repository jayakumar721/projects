package in.vamsoft.assignment;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


class NameComparator implements Comparator<Customer>{


  @Override
  public int compare(Customer o1, Customer o2) {
    return (o1.name.compareTo(o2.name));
  }
  
}

class IdComparator implements Comparator<Customer>{


  @Override
  public int compare(Customer o1, Customer o2) {
    if (o1.custId < o2.custId) {
      return -1;
    } else if (o1.custId > o2.custId){
      return 1;
    } else {
      return 0;
    }
  }
  
}

class MobComparator implements Comparator<Customer>{


  @Override
  public int compare(Customer o1, Customer o2) {
    if (o1.mobile < o2.mobile) {
      return -1;
    } else if (o1.mobile > o2.mobile) {
      return 1;
    } else {
      return 0;
    }
  }
  
}


public class CustomerTest {
  
  /**
   * @param args.
   */
  public static void main(String[] args) {
     
    List<Customer> list = new LinkedList<>();
    Customer e1 = new Customer(1,"A",874563211,"Chennai");
    Customer e2 = new Customer(5,"C",675563211,"Bangalore");
    Customer e3 = new Customer(4,"D",774563211,"Hyderabad");
    Customer e4 = new Customer(6,"B",874465211,"Vizag");
    
    list.add(e1);
    list.add(e2);
    list.add(e3);
    list.add(e4);
    Collections.sort(list,new IdComparator());
    for (Customer c:list) {
      System.out.println(c);
    }
    
    System.out.println("-------------------------------------------------------");
    
    Collections.sort(list,new NameComparator());
    for (Customer c:list) {
      System.out.println(c);
    }
    
    System.out.println("-------------------------------------------------------");
    Collections.sort(list,new MobComparator());
    for (Customer c:list) {
      System.out.println(c);
    }
    
  }

}
