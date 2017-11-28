package in.vamsoft.demo;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.jdbc.DBConnectionUtil;

public class EmployeeJDBCImplen implements EmployeeDAO {

  Connection con = null;
  ResultSet resultSet = null;

  public EmployeeJDBCImplen() {
    this.con = DBConnectionUtil.getConnection();
  }

  @Override
  public boolean addEmployee(Employee emp) {
    try (PreparedStatement preparedStatement = con.prepareStatement("insert into empcopy values(?,?,?,?,?)")) {
      preparedStatement.setInt(1, emp.getEmpid());
      preparedStatement.setString(2, emp.getName());
      preparedStatement.setInt(3, emp.getSalary());
      preparedStatement.setDate(4, Date.valueOf(emp.getDate()));
      preparedStatement.setInt(5, emp.getDeptid());
      int i = preparedStatement.executeUpdate();
      return i > 0 ? true : false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean removeEmployee(int empid) {
    try (PreparedStatement preparedStatement = con.prepareStatement("delete empcopy where empid=?")) {
      preparedStatement.setInt(1, empid);
      int i = preparedStatement.executeUpdate();
      return i > 0 ? true : false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public Employee findEmployee(int empid) {
    try (PreparedStatement preparedStatement = con.prepareStatement("select * from empcopy where empid=?");) {
      preparedStatement.setInt(1, empid);
      ResultSet i = preparedStatement.executeQuery();
      Employee employee = null;
      if (i.next()) {
        employee = new Employee();
        employee.setEmpid(i.getInt(1));
        employee.setName(i.getString(2));
        employee.setSalary(i.getInt(3));
        employee.setDate((i.getDate(4)).toLocalDate());
        employee.setDeptid(i.getInt(5));
        return employee;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<Employee> allEmployee() {

    List<Employee> list = new ArrayList<>();
    try (PreparedStatement preparedStatement = con
        .prepareStatement("select empid,fname,salary,doj,deptid from empcopy")) {

      ResultSet i = preparedStatement.executeQuery();
      Employee employee = null;
      while (i.next()) {
        employee = new Employee();
        employee.setEmpid(i.getInt(1));
        employee.setName(i.getString(2));
        employee.setSalary(i.getInt(3));
        employee.setDate((i.getDate(4)).toLocalDate());
        employee.setDeptid(i.getInt(5));
        list.add(employee);
      }
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
