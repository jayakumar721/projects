package in.vamsoft.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
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
  ServletContext context;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    session = request.getSession();
    context = this.getServletContext();
    PrintWriter out = response.getWriter();
    Object name = session.getAttribute("uname");
    Double discount = (Double) context.getAttribute("discount");
    Double gst = (Double) context.getAttribute("gst");
    double total;
    if (name == null) {
      response.sendRedirect("Login.html");
    } else {
      @SuppressWarnings("unchecked")
      HashMap<String, Double> bill = (HashMap<String, Double>) request.getAttribute("bill");
      for (Map.Entry<String, Double> entry : bill.entrySet()) {
        total = entry.getValue() + entry.getValue() * gst - entry.getValue() * discount;
        out.println("<html><body><h4>Product name :" + entry.getKey() + "<br>Product price :" + entry.getValue()
            + "<br>Gst :" + gst + "<br>Discount :" + discount + "<br>Total :" + total + "</h5></body></html>");
      }
    }
  }

}
