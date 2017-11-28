package in.vamsoft.dao;

import java.util.List;

import in.vamsoft.model.Department;
import in.vamsoft.model.Employee;

public interface EmpDao {

  /* (non-Javadoc)
   * @see in.vamsoft.dao.EmpDao#getAllDept()
   */
  List<Department> getAllDept();

  /* (non-Javadoc)
   * @see in.vamsoft.dao.EmpDao#findEmployeeByDept(int)
   */
  List<Employee> findEmployeeByDept(int deptId);

  boolean addEmployee(Employee emp);

  boolean deleteEmployee(int id);

  boolean updateEmployee(Employee emp);

}