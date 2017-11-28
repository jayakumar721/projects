package in.vamsoft.model;

import java.time.LocalDate;

public class Employee {

  
  private int empNo;
  private String empName;
  private double salary;
  private LocalDate date ;
  private int deptId;
  public int getEmpNo() {
    return empNo;
  }
  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }
  public String getEmpName() {
    return empName;
  }
  public void setEmpName(String empName) {
    this.empName = empName;
  }
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }

  public LocalDate getDate() {
    return date;
  }
  public void setDate(LocalDate date) {
    this.date = date;
  }
  public int getDeptId() {
    return deptId;
  }
  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }
  public Employee(int empNo, String empName, double salary, LocalDate date, int deptId) {
    super();
    this.empNo = empNo;
    this.empName = empName;
    this.salary = salary;
    this.date = date;
    this.deptId = deptId;
  }
  public Employee() {
  }
  @Override
  public String toString() {
    return "Employee [empNo=" + empNo + ", empName=" + empName + ", salary=" + salary + ", date=" + date +", deptId="
        + deptId + "]";
  }
  
}
