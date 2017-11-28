package in.vamsoft.java;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ELServlet
 */
@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  Address address = new Address();
	  address.setHouseNo("U4");
	  address.setCity("Chennai");
	  
	  Employee e1 = new Employee(1, "jk", 12500, LocalDate.now(), 20, address);
	  Employee e2 = new Employee(2, "jj", 12599, LocalDate.now(), 10, address);
	  
	  request.setAttribute("employee", e1);
	  HttpSession session = request.getSession();
	  session.setAttribute("employee1", e2);
	  
	  response.addCookie(new Cookie("User.Cookie", "Jakle"));
	  
	  ServletContext context = getServletContext();
	  context.setAttribute("User.Cookie", "Jakle");
	  
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
	  dispatcher.forward(request, response);
	  
	}

}
