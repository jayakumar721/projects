package in.vamsoft.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeTest {

  public static void main(String[] args) {
    EmployeeDAO daoFactory = EmployeeDAOFactory.createEmployeeDAO();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.println("Enter employee details to insert into db");
      System.out.println("empid");
      int empId = Integer.parseInt(bufferedReader.readLine());

      System.out.println("empname");
      String empName = bufferedReader.readLine();

      System.out.println("Salary");
      int empSalary = Integer.parseInt(bufferedReader.readLine());

      System.out.println("DOJ");
      LocalDate doj = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

      System.out.println("DeptId");
      int DeptId = Integer.parseInt(bufferedReader.readLine());

      Employee emp = new Employee(empId, empName, empSalary, doj, DeptId);

      boolean insert = daoFactory.addEmployee(emp);
      if (insert) {
        System.out.println("inserted successfully");
      } else {
        System.out.println("not added");

      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
