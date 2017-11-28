package in.vamsoft.filters;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  session = request.getSession();
	  String name = request.getParameter("name");
	  String pass = request.getParameter("pass");
	  if(name.equals("jk")&&pass.equals("pass")) {
	    session.setAttribute("name", name);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("Servlet1");
	    dispatcher.forward(request, response);
	  } else {
	    response.sendRedirect("Login.html");
	  }
	
	}

}
