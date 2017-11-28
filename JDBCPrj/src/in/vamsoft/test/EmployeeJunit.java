package in.vamsoft.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import in.vamsoft.demo.Employee;
import in.vamsoft.demo.EmployeeDAO;
import in.vamsoft.demo.EmployeeDAOFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmployeeJunit {
  static EmployeeDAO dao;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    dao = EmployeeDAOFactory.createEmployeeDAO();
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @Test
  void testAddEmployee() {
    Employee emp = new Employee(104, "siva", 12000,
        LocalDate.parse("12-10-2017", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 90);
    boolean result = dao.addEmployee(emp);
    assertTrue(result);
  }

  @Test
  void testRemoveEmployee() {
    int empid = 104;
    boolean result = dao.removeEmployee(empid);
    assertTrue(result);
  }

  @Test
  void testFindEmployee() {
    int empid = 103;
    Employee emp = dao.findEmployee(empid);
    assertNotNull(emp);
    assertEquals(empid, emp.getEmpid());

  }

  @Test
  void testAllEmployee() {
    List<Employee> list = dao.allEmployee();
    assertTrue(list.size()>0);
    assertNotNull(list.get(0));
  }

}
