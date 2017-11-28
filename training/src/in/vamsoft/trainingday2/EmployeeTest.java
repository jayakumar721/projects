package in.vamsoft.trainingday2;

import in.vamsoft.trainingday2.InvalidSalaryException.Salary;

public class EmployeeTest {
  
  /**
   * @param args .
   * @throws InvalidSalaryException .
   */
  public static void main(String[] args) {
   
    Employee emp = new Employee();
    try {
     
      emp.setEmpId(1);
      emp.setEmpName("jk");
      emp.setAge(20);
      emp.setSalary(300001);
      
    } catch (InvalidSalaryException e) {
        
      if (e.errorcode == Salary.min_Salary) {
        try {
          emp.setSalary(27000);
        } catch (InvalidSalaryException e1) {
          e1.printStackTrace();
        }
      } else if (e.errorcode == Salary.max_Salary) {
        try {
          emp.setSalary(299000);
        } catch (InvalidSalaryException e1) {
          e1.printStackTrace();
        }
      }
      
    
    }
    
    System.out.println("Employee Details : " + emp);
  
  }
}
