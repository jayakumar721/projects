package in.vamsoft.assign2;

import java.io.IOException;

import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  HttpSession session;


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    session = request.getSession();
    Object name = session.getAttribute("uname");

    if (name == null) {
      response.sendRedirect("Login.html");
    } else {
      @SuppressWarnings("unchecked")
      HashMap<String, Double> bill = (HashMap<String, Double>) getServletContext().getAttribute("bill");
      System.out.println("bill srvlet"+bill);
      RequestDispatcher dispatcher = request.getRequestDispatcher("bill.jsp");
      dispatcher.include(request, response);
    }
  }

}
