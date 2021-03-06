package in.vamsoft.services;

import java.util.List;

import in.vamsoft.dao.EmpDao;
import in.vamsoft.dao.EmpDaoFactory;
import in.vamsoft.model.Department;
import in.vamsoft.model.Employee;

public class EmpServices implements ServiceDao {

  EmpDao dao = EmpDaoFactory.getEmployeeObjects();
  /* (non-Javadoc)
   * @see in.vamsoft.services.ServiceDao#getAllDepartments()
   */
  /* (non-Javadoc)
   * @see in.vamsoft.services.ServiceDao#getAllDepartments()
   */
  @Override
  public List<Department> getAllDepartments(){
    return dao.getAllDept();
  }
  
  /* (non-Javadoc)
   * @see in.vamsoft.services.ServiceDao#getEmoloyeeByDept(int)
   */
  /* (non-Javadoc)
   * @see in.vamsoft.services.ServiceDao#getEmoloyeeByDept(int)
   */
  @Override
  public List<Employee> getEmoloyeeByDept(int deptId){
    return dao.findEmployeeByDept(deptId);
  }
  
  /* (non-Javadoc)
   * @see in.vamsoft.services.ServiceDao#addEmployee(in.vamsoft.model.Employee)
   */
  @Override
  public boolean addEmployee(Employee emp) {
    return dao.addEmployee(emp);
  }
  @Override
  public boolean deleteEmployee(int id) {
    return dao.deleteEmployee(id);
  }

  @Override
  public boolean updateEmployee(Employee emp) {
    // TODO Auto-generated method stub
    return dao.updateEmployee(emp);
  }
}
