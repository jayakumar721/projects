package in.vamsoft.servlet.dao;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Catalog
 */
@WebServlet("/Cart1")
public class Cart1 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  HttpSession session;
  ServletContext context;
  CartDao daoImpl;
  @Override
  public void init() throws ServletException {
    daoImpl = new CartDaoImpl();
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    context=this.getServletContext();
    session = request.getSession();
    Object uname = session.getAttribute("uname");
    
    context.setAttribute("discount", 0.10);
    context.setAttribute("gst", 0.28);
    
    if (uname == null) {
      response.sendRedirect("login.html");
    } else {
      String bear[] = request.getParameterValues("bear");
      String mobiles[] = request.getParameterValues("mobile");
      
      Map<String, Double> map = daoImpl.cart(bear, mobiles);
      System.out.println(map);
      context.setAttribute("bill", map);
      RequestDispatcher dispatcher = request.getRequestDispatcher("Address.html");
      dispatcher.include(request, response);
    }

  }

}
