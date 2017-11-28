package in.vamsoft.assign;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeSalaryServlet
 */

@WebServlet("/EmployeeSalaryServlet")
public class EmployeeSalaryServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name");
    String doj = request.getParameter("doj");
    LocalDate lDate;

    try {
      lDate = LocalDate.parse(doj, DateTimeFormatter.ofPattern("dd-MM-yyy"));
      if (name.isEmpty() || doj.isEmpty()) {
        throw new MyException("Empty Field");
      } else if (lDate.isAfter(LocalDate.now().minusYears(1)) && lDate.isBefore(LocalDate.now())) {
        request.setAttribute("salary", 30000);
        System.out.println("30000");
      } else if (lDate.isBefore(LocalDate.now().minusYears(1)) && lDate.isAfter(LocalDate.now().minusYears(2))) {
        request.setAttribute("salary", 40000);
        System.out.println("40000");
      } else if (lDate.isBefore(LocalDate.now().minusYears(2))) {
        request.setAttribute("salary", 60000);
      } else {
        request.setAttribute("salary", 0);
      }
      RequestDispatcher dispatcher = request.getRequestDispatcher("SalarySlipServlet");
      dispatcher.forward(request, response);

    } catch (MyException e) {
      request.setAttribute("Error", e.getMessage());
      RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorServlet");
      dispatcher.forward(request, response);

    } catch(DateTimeException e) {
      e=new DateTimeException("Date format Exception");
      request.setAttribute("Error", e.getMessage());
      RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorServlet");
      dispatcher.forward(request, response);
    }

    // try {
    // if(name.equals("jk")) {
    // System.out.println("yes");
    // }else {
    // throw new MyException("empty name");
    // }
    // } catch(MyException e) {
    // System.out.println(e.getMessage());
    //
    // }

  }

}
