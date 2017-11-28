package in.vamsoft.assignment2;

public class Manager extends Employee{

  private String deptName;
  public Manager(int empId, String name, int ssn, double salary, String deptName) {
    super(empId, name, ssn, salary);
    this.deptName = deptName;
  }
  public String getDeptName() {
    return deptName;
  }
  
}
