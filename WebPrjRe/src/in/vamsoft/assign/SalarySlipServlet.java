package in.vamsoft.assign;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SalarySlipServlet
 */
@WebServlet("/SalarySlipServlet")
public class SalarySlipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	  String name = (String) request.getParameter("name");
	  String doj = (String) request.getParameter("doj");
	  int salary = (int) request.getAttribute("salary");
	  double total;

	  total = salary+salary*0.1+salary*0.1-salary*0.12;
	  out.println("<html><body>Name: "+name+"<br>Date of join: "+doj+"<br>Salary: "+total);
	  
	}

}
