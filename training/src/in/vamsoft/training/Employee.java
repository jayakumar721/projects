package in.vamsoft.training;

public class Employee {

  private final int empCode;
  private String empName;
  private double salary;
  private double increment;

  /**
   * @param id
   *          .
   * @param name
   *          .
   * @param salary
   *          .
   */
  public Employee(int id, String name, double salary) {
    empCode = id;
    this.salary = salary;
    empName = name;
  }

  public Employee(int empCode, String empName) {
    this(empCode, empName, 15000);
  }

  public int getEmpCode() {
    return empCode;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  /**
   * @param increment .
   */
  public void setIncrement(double increment) {
    this.increment = increment;
    if (this.increment > (this.getSalary() * 0.1)) {
      salary = salary + increment;
    } else {
      System.out.println("increment cannot be done for less than 10%");
    }
  }

  public double getSalary() {
    return salary;
  }

}
