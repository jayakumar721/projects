package in.vamsoft.day2collections;

import java.util.HashSet;

import java.util.Set;

public class SetDemo {

  /**
   * @param args .
   */
  public static void main(String[] args) {
    Set<Emp> set = new HashSet<>();
    Emp e = new Emp(1,"aa",21);
    Emp e1 = new Emp(2,"ba",81);
    Emp e2 = new Emp(3,"sa",51);
    Emp e3 = new Emp(4,"ja",61);
    Emp e4 = new Emp(5,"fa",27);
    Emp e5 = new Emp(6,"ha",84);
    Emp e6 = new Emp(7,"d",11);
    set.add(e);
    set.add(e1);
    set.add(e2);
    set.add(e3);
    set.add(e4);
    set.add(e5);
    set.add(e6);
    System.out.println(set);
  }
  
}
