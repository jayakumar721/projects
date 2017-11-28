package in.vamsoft.trainingday2;


public class EmployeeSet implements Comparable<EmployeeSet> {
  
  private int empId;
  private String empName;
  private double salary;
  private int age;
  
  
  
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
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  /**
   * @return .
   */
  public double getSalary() {
  
    return salary;
  }
  

  /**
   * @param empId .
   * @param empName .
   * @param salary .
   * @param age .
   */
  public EmployeeSet(int empId, String empName, double salary, int age) {
    super();
    this.empId = empId;
    this.empName = empName;
    this.salary = salary;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee [empId=" + empId + ", empName=" + empName 
        + ", salary=" + salary + ", age=" + age + "]";
  }

  @Override
  public int compareTo(EmployeeSet o) {
   
    if (this.empId < o.empId) {
      return -1;
    } else if (this.empId > o.empId) {
      return 1;
    }
    return 0;
  }
  
  

}
