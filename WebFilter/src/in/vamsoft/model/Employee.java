package in.vamsoft.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empcopy")
public class Employee {

  @Id
  @Column(name="empid")
  private int empNo;
  @Column(name="fname")
  private String empName;
  @Column(name="salary")
  private double salary;
  @Column(name="doj")
  private LocalDate date ;
  @Column(name="deptid")
  private Integer deptId;
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
        + deptId + "]\n";
  }
  
}
