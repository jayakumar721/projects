package in.vamsoft.assignment2;

public class Employee {
  
  private int empId;
  private String name;
  private int ssn;
  private double salary;
  public int getEmpId() {
    return empId;
  }
 
  public String getName() {
    return name;
  }
  public void setName(String name) {
    if (name.isEmpty() || name.trim().equals("")) {
      this.name = "Name should not be Empty or null";
    }else {
      
      this.name = name;
    }
  }
  public int getSsn() {
    return ssn;
  }
 
  public double getSalary() {
    return salary;
  }
  
  public Employee(int empId, String name, int ssn, double salary) {
    super();
    this.empId = empId;
    this.name = name;
    this.ssn = ssn;
    this.salary = salary;
  }
  public Employee() {
    // TODO Auto-generated constructor stub
  }
  
  public void raiseSalary (double increase) {
    
   if(increase > 0) {
     double i = salary*0.1;
     if(increase >= i) {
       salary += increase;
     }
     
   } else {
    System.out.println("Invalid Hike..!!");
  }
    
  }
  

}
