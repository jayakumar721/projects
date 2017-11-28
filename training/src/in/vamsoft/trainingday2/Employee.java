package in.vamsoft.trainingday2;

import in.vamsoft.trainingday2.InvalidSalaryException.Salary;


public class Employee {
  
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
   * @param salary .
   * @throws InvalidSalaryException .
   */
  public void setSalary(double salary) throws InvalidSalaryException {
    if (salary <= 25000) {
      throw new InvalidSalaryException("Minimum salary occured!!", Salary.min_Salary);
    } else if (salary > 300000) {
      throw new InvalidSalaryException("Minimum salary occured!!", Salary.max_Salary);
    }
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee [empId=" + empId + ", empName=" + empName 
        + ", salary=" + salary + ", age=" + age + "]";
  }
  
  

}
