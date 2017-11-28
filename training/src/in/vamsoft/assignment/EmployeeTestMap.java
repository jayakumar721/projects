package in.vamsoft.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeTestMap {
  Map<Integer, Employee> map = new HashMap<>();
  
  /**
   * @param emp.
   * @return.
   */
  public boolean addEmp(Employee emp) {
    
    if (!map.containsValue(emp)) {
      map.put(emp.getEmpId(), emp);
      return true;
    } else {
      return false;
    }
    
  }
  
  /**
   * @param emp.
   * @return.
   */
  public boolean removeEmp(int empid) {
    
    if (map.containsKey(empid)) {
      map.remove(empid);
      return true;
    } else {
      return false;
    }
    
  }

  
  /**
   * @param args.
   */
  public static void main(String[] args) {
    
    EmployeeTestMap em = new EmployeeTestMap();
    System.out.println("----------------------");
    System.out.println("Employee Details");
    System.out.println("----------------------");
    System.out.println("1.Add Employee");
    System.out.println("2.Delete Employee");
    System.out.println("3.View Employee");
    System.out.println("4.View All Employee");
    System.out.println("----------------------");
    
    System.out.println("Enter your choice..!");
    Scanner sc = new Scanner(System.in);
    
    int ch = sc.nextInt();
    switch (ch) {
      case 1: 
        System.out.println("Enter the Employee Details:");
        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();
        int salary = sc.nextInt();
        Employee e1 = new Employee(name, salary);
        em.addEmp(e1);
        break;
      case 2: 
        System.out.println("Enter the employee code to remove:");
        int id3 = sc.nextInt();
        em.removeEmp(id3);
        break;
      case 3:
     
        break;     
      case 4:
        
        break;      
      default:
        System.out.println("Invalid Entry....");
    }
    sc.close();
     
    
  }
}
