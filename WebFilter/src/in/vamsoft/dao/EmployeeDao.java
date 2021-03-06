package in.vamsoft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.model.Department;
import in.vamsoft.model.Employee;

public class EmployeeDao implements EmpDao {

  Connection connection;
  ResultSet resultSet;

  public EmployeeDao() {
    connection = DBConnectionUtil.getConnection();
  }

  /*
   * (non-Javadoc)
   * 
   * @see in.vamsoft.dao.EmpDao#getAllDept()
   */
  /*
   * (non-Javadoc)
   * 
   * @see in.vamsoft.dao.EmpDao#getAllDept()
   */
  @Override
  public List<Department> getAllDept() {
    List<Department> list = new ArrayList<>();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("Select distinct department_id,department_name from departments")) {
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Department department = new Department();
        department.setDeptNo(resultSet.getInt(1));
        department.setDeptName(resultSet.getString(2));
        list.add(department);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;

  }

  /*
   * (non-Javadoc)
   * 
   * @see in.vamsoft.dao.EmpDao#findEmployeeByDept(int)
   */
  /*
   * (non-Javadoc)
   * 
   * @see in.vamsoft.dao.EmpDao#findEmployeeByDept(int)
   */
  @Override
  public List<Employee> findEmployeeByDept(int deptId) {
    List<Employee> emp = new ArrayList<>();
    try (PreparedStatement preparedStatement = connection.prepareStatement("select * from empcopy where deptid=?")) {
      preparedStatement.setInt(1, deptId);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Employee employee = new Employee();
        employee.setEmpNo(resultSet.getInt(1));
        employee.setEmpName(resultSet.getString(2));
        employee.setSalary(resultSet.getDouble(3));
        employee.setDate(resultSet.getDate(4).toLocalDate());
        employee.setDeptId(resultSet.getInt(5));
        emp.add(employee);

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return emp;

  }

  /*
   * (non-Javadoc)
   * 
   * @see in.vamsoft.dao.EmpDao#addEmployee(in.vamsoft.model.Employee)
   */
  @Override
  public boolean addEmployee(Employee emp) {
    try (PreparedStatement preparedStatement = connection.prepareStatement("insert into empcopy values(?,?,?,?,?)")) {

      preparedStatement.setInt(1, emp.getEmpNo());
      preparedStatement.setString(2, emp.getEmpName());
      preparedStatement.setDouble(3, emp.getSalary());
      preparedStatement.setDate(4, Date.valueOf(emp.getDate()));
      preparedStatement.setInt(5, emp.getDeptId());
      int i = preparedStatement.executeUpdate();
      return i > 0 ? true : false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;

  }

  /*
   * (non-Javadoc)
   * 
   * @see in.vamsoft.dao.EmpDao#deleteEmployee(int)
   */
  @Override
  public boolean deleteEmployee(int id) {

    try (PreparedStatement preparedStatement = connection.prepareStatement("delete empcopy where empid=?")) {
      preparedStatement.setInt(1, id);
      int i = preparedStatement.executeUpdate();
      return i > 0 ? true : false;
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;

  }

  @Override
  public boolean updateEmployee(Employee emp) {

    try (PreparedStatement preparedStatement = connection
        .prepareStatement("update empcopy set fname=?,salary=?,doj=? where empid=? ")) {

      preparedStatement.setString(1, emp.getEmpName());
      preparedStatement.setDouble(2, emp.getSalary());
      preparedStatement.setDate(3, Date.valueOf(emp.getDate()));
      preparedStatement.setInt(4, emp.getEmpNo());
      int i = preparedStatement.executeUpdate();
      return i > 0 ? true : false;
    
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

}
