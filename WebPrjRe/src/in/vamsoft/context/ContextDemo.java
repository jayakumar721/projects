package in.vamsoft.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextDemo
 */
@WebServlet("/ContextDemo")
public class ContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  context= this.getServletContext();
		context.setAttribute("Message", "Hello");
		response.sendRedirect("SampleServlet");
	}

}
