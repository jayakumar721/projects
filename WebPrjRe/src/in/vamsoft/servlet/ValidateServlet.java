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
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    PrintWriter out = response.getWriter();

    if (name.equals("jk") && pass.equals("jayakumar")) {

      response.sendRedirect("Success.html");

    } else {
      out.println("hello");
      RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorServlet");
      dispatcher.forward(request, response);
    }
  }

}
