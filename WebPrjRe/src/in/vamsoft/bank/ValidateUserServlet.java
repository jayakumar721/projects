package in.vamsoft.bank;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateUserServlet
 */
@WebServlet("/ValidateUserServlet")
public class ValidateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  session = request.getSession();
	  String name = request.getParameter("name");
	  String password = request.getParameter("pass");
	  if(name.equals("jk") && password.equals("password")) {
	    session.setAttribute("name", name);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("HomePageServlet");
	    dispatcher.forward(request, response);
	  } else {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorServlet2");
	    dispatcher.forward(request, response);
	  }
	  
	}

}
