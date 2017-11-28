package in.vamsoft.sessions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetSessionServlet
 */
@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  String name = request.getParameter("name");
	  String color = request.getParameter("favColor");
	  Cookie cName = new Cookie("nCookie", name);
	  Cookie cColor = new Cookie("cCookie", color);
	  response.addCookie(cName);
	  response.addCookie(cColor);
	  response.getWriter().println("<html><body>"+name+" your preferences is "+color+"</body></html>");
	  
	}

}
