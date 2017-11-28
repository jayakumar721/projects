package in.vamsoft.assignment2;

public class EmployeeTest { 
  
  public static void printEmployee(Employee employee) {
    
    System.out.println("----------------------------");
    System.out.println("Employee Id  : " + employee.getEmpId());
    System.out.println("Employee Name : " + employee.getName());
    System.out.println("Employee ssn : " + employee.getSsn());
    System.out.println("Employee salary : " + employee.getSalary());
  }
  public static void main(String[] args) {
    
    Engineer engineer = new Engineer(101, "Jane smith", 5678, 120347);
    Manager manager = new Manager(207, "Barbara Johnson", 2367, 109501, "US Marketing");
    Admin admin = new Admin(304, "Bill Monroe", 6509, 75002);
    
    Director director = new Director(12, "Susan Wheeler", 2340, 120567, "Global Marketing", 1000000);
    
    printEmployee(engineer);
    printEmployee(manager);
    printEmployee(admin);
    printEmployee(director);
   
    
    manager.setName("   ");
    printEmployee(manager);
    manager.raiseSalary(50000);
    System.out.println("Salary after hike : " +manager.getSalary());
    
   
    
  }

}
