package in.vamsoft.dao;

public class EmpDaoFactory {

  public static EmpDao getEmployeeObjects() {
    return new EmployeeDao();
  }
  
}
