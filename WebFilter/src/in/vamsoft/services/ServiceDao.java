package in.vamsoft.services;

import java.util.List;

import in.vamsoft.model.Department;
import in.vamsoft.model.Employee;

public interface ServiceDao {

  /* (non-Javadoc)
   * @see in.vamsoft.services.ServiceDao#getAllDepartments()
   */
  List<Department> getAllDepartments();

  /* (non-Javadoc)
   * @see in.vamsoft.services.ServiceDao#getEmoloyeeByDept(int)
   */
  List<Employee> getEmoloyeeByDept(int deptId);

  boolean addEmployee(Employee emp);
  boolean deleteEmployee(int id);
  boolean updateEmployee(Employee emp);
}