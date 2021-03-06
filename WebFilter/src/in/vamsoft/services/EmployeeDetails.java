package in.vamsoft.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.model.Employee;

/**
 * Servlet implementation class EmployeeDetails
 */
@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    String name = request.getParameter("name");
    
    ServiceDao service = new EmpServices();
    String opt = request.getParameter("operation");
    System.out.println(opt);
    if (opt.equals("get")) { 
      int deptId = Integer.parseInt(request.getParameter("deptId"));
      List<Employee> employees = service.getEmoloyeeByDept(deptId);
      HttpSession session = request.getSession();
      session.setAttribute("employees", employees);
      RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeDetails.jsp");
      dispatcher.include(request, response);
    } else if(opt.equals("add")) {
      int id = Integer.parseInt(request.getParameter("id"));
      int deptId = Integer.parseInt(request.getParameter("deptId"));
      double salary = Double.parseDouble(request.getParameter("salary"));
      LocalDate date = LocalDate.parse(request.getParameter("doj"),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
      Employee emp = new Employee(id, name, salary, date, deptId);
      boolean add = service.addEmployee(emp);
      if(add) {
        response.getWriter().println("added successfully");
      }
    } else if(opt.equals("delete")) {
      int id = Integer.parseInt(request.getParameter("id"));
      boolean del = service.deleteEmployee(id);
      int deptId = Integer.parseInt(request.getParameter("deptId"));

      if(del) {
        //response.getWriter().println("deleted successfully");
        List<Employee> employees = service.getEmoloyeeByDept(deptId);
        HttpSession session = request.getSession();
        session.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeDetails.jsp");
        dispatcher.include(request, response);
      }
    } else if(opt.equals("update")) {
      int id = Integer.parseInt(request.getParameter("id"));
      int deptId = Integer.parseInt(request.getParameter("deptId"));
      double salary = Double.parseDouble(request.getParameter("salary"));
      LocalDate date = LocalDate.parse(request.getParameter("doj"),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
      Employee emp = new Employee(id, name, salary, date, deptId);
      boolean update = service.updateEmployee(emp);
      if(update) {
        //response.getWriter().println("deleted successfully");
        List<Employee> employees = service.getEmoloyeeByDept(deptId);
        HttpSession session = request.getSession();
        session.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeDetails.jsp");
        dispatcher.include(request, response);
      }
    }

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doPost(req, resp);
  }

}
