package in.vamsoft.demo;

public class EmployeeDAOFactory {
  
  public static EmployeeDAO createEmployeeDAO() {
    EmployeeJDBCImplen employee = new EmployeeJDBCImplen();
    return employee;
  }

}
