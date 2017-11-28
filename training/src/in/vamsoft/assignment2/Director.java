package in.vamsoft.assignment2;

public class Director extends Manager {

  private double budget;
  public Director(int empId, String name, int ssn, double salary, String deptName, double budget) {
    super(empId, name, ssn, salary, deptName);
    this.budget = budget;
  }
  public double getBudget() {
    return budget;
  }
 
  
  
  
}
