package in.vamsoft.assign3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class calculate
 */
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  session = request.getSession();
	  String opt = request.getParameter("operation");
	  double value1 = Double.parseDouble(request.getParameter("op1"));
	  double value2 = Double.parseDouble(request.getParameter("op2"));
	  double result=0;
	  if(opt.equals("add")) {
	    result = value1+value2;
	  } else if(opt.equals("sub")) {
	     result = value1-value2;
	  } else if(opt.equals("mul")) {
	     result = value1*value2;
	  } else if(opt.equals("div")) {
	     result = value1/value2;
	  }
	  
	  session.setAttribute("result", result);
	  RequestDispatcher dispatcher = request.getRequestDispatcher("calc.jsp");
	  dispatcher.forward(request, response);
	
	}

}
