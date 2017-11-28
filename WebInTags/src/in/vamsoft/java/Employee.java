package in.vamsoft.java;

import java.time.LocalDate;

public class Employee {

  int empid;
  String name;
  int salary;
  LocalDate date;
  int deptid;
  Address address;

  public Employee() {
    // TODO Auto-generated constructor stub
  }
  public int getDeptid() {
    return deptid;
  }
  public void setDeptid(int deptid) {
    this.deptid = deptid;
  }
  public int getEmpid() {
    return empid;
  }
  public void setEmpid(int empid) {
    this.empid = empid;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getSalary() {
    return salary;
  }
  public void setSalary(int salary) {
    this.salary = salary;
  }
  public LocalDate getDate() {
    return date;
  }
  public void setDate(LocalDate date) {
    this.date = date;
  }
  public Address getAddress() {
    return address;
  }
  public void setAddress(Address address) {
    this.address = address;
  }
  public Employee(int empid, String name, int salary, LocalDate date, int deptid, Address address) {
    super();
    this.empid = empid;
    this.name = name;
    this.salary = salary;
    this.date = date;
    this.deptid = deptid;
    this.address = address;
  }
  @Override
  public String toString() {
    return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + ", date=" + date + ", deptid="
        + deptid + ", address=" + address + "]";
  }
  

  
}
