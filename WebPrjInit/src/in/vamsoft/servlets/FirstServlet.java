package in.vamsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	String cName;
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
	  this.config = config;
	  cName = config.getInitParameter("companyname");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 PrintWriter out = response.getWriter();
	 ServletContext context =config.getServletContext();
	 String city = context.getInitParameter("city");
	 out.println("<html><body>"+cName+ " " +city+"</body></html>");
	}

}
