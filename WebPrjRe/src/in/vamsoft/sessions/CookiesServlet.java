package in.vamsoft.sessions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlet
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  Cookie cookie[] = request.getCookies();
	  String name = "";
	  String color = "";
	
	  if(cookie != null) {
	    for(Cookie c : cookie) {
	      if(c.getName().equals("nCookie")) {
	        name = c.getValue();
	      }
	      if(c.getName().equals("cCookie")) {
	        color = c.getValue();
	      }
	    }
	  }
	  response.getWriter().println("<html><body bgcolor='"+color+"'><h2> Welcome "+name+"</h2></body></html>");

	
	}

}
