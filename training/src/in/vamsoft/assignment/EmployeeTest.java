package in.vamsoft.assignment;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmployeeTest {
  
  /**
   * @param args.
   */
  public static void main(String[] args) {
    
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
    List<Employee> list = new LinkedList<>();
    Employee e1 = new Employee(1,"a",2500);
    Employee e2 = new Employee(2,"b",8500);
    Employee e3 = new Employee(3,"c",3500);
    list.add(e1);
    list.add(e2);
    list.add(e3);
    int ch = sc.nextInt();
    switch (ch) {
      case 1: 
        System.out.println("Enter the Employee Id:");
        int id1 = sc.nextInt();
        System.out.println("Enter the Employee Name:");
        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();
        System.out.println("Enter the salary:");
        int salary = sc.nextInt();
        Employee e4 = new Employee(id1, name, salary);
        list.add(e4);
        sc1.close();
        
        break;
      case 2: 
        System.out.println("Enter the Employee Id to remove:");
        int id2 = sc.nextInt();
        list.remove(id2);
        System.out.println("Employee Removed!!");
        break;
      case 3:
        System.out.println("Enter the Employee Id to view:");
        int id3 = sc.nextInt();
        System.out.println(list.get(id3));
        break;     
      case 4:
        System.out.println(list);
        break;      
      default:
        System.out.println("Invalid Entry....");
    }
    sc.close();
    
  }

}
