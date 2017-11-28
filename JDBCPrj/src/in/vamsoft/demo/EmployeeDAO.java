package in.vamsoft.demo;

import java.util.List;

public interface EmployeeDAO {

  boolean addEmployee(Employee emp);

  boolean removeEmployee(int empid);

  Employee findEmployee(int empid);

  

  List<Employee> allEmployee();

}