package in.vamsoft.assignment;

public class Employee {

  static int empCounter;
  int empId;
  String empName;
  int salary;
  
  
  /**
   * @param empId.
   * @param empName.
   * @param salary.
   */
  public Employee(String empName, int salary) {
    super();
    empCounter += 1;
    this.empId = empCounter;
    this.empName = empName;
    this.salary = salary;
    
    
  }


  /**
   * @param empId.
   * @param empName.
   * @param salary.
   */
  public Employee(int empId, String empName, int salary) {
    super();
    this.empId = empId;
    this.empName = empName;
    this.salary = salary;
  }


  @Override
  public String toString() {
    return "Employee [empId=" + empId + ", empName=" + empName 
        + ", salary=" + salary + "]\n";
  }


  public int getEmpId() {
    return empId;
  }


  public void setEmpId(int empId) {
    this.empId = empId;
  }


  public String getEmpName() {
    return empName;
  }


  public void setEmpName(String empName) {
    this.empName = empName;
  }


  public int getSalary() {
    return salary;
  }


  public void setSalary(int salary) {
    this.salary = salary;
  }
}
