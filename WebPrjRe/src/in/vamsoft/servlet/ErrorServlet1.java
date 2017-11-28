package in.vamsoft.servlet;

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
@WebServlet("/ErrorServlet1")
public class ErrorServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  PrintWriter out = response.getWriter();
	  out.println("<h1 style=font-family:chiller>sorry..! Wrong Credentials</h1>");
	  RequestDispatcher dispatcher = request.getRequestDispatcher("Index.html");
	  dispatcher.include(request, response);
	
	}

}
