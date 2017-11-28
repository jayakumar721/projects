package in.vamsoft.assign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  PrintWriter out = response.getWriter();
	  String message = (String) request.getAttribute("Error");
	  out.println("<h1>"+message+"</h1>");
	  RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeDetails.html");
	  dispatcher.include(request, response);
	
	}

}
