package in.vamsoft.assignment;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
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
@WebServlet("/Cart")
public class Cart extends HttpServlet {
  private static final long serialVersionUID = 1L;

  HttpSession session;
  ServletContext context;
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
      HashMap<String, Double> map = new HashMap<String, Double>();
      map.put("American Black Bear", 122.0);
      map.put("Asiatic Black Bear", 132.0);
      map.put("Brown Bear", 142.0);
      map.put("Giant Panda", 131.0);
      map.put("Sloth Bear", 112.0);
      map.put("Sun Bear", 154.0);
      map.put("Polar Bear", 150.0);
      map.put("Spectacled Bear", 132.0);
      HashMap<String, Double> map1 = new HashMap<>();
      map1.put("moto g4", 45000.00);
      map1.put("redmi note 4", 1000.00);
      map1.put("iphone 5", 25000.00);
      HashMap<String, Double> mapAdd = new HashMap<>();
      if (bear.length > 0 || mobiles.length > 0) {

        for (int i = 0; i < bear.length; i++) {
          String bears = bear[i];
          for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            if (bears.equals(key)) {
              mapAdd.put(key, entry.getValue());
            }

          }
        }

        for (int i = 0; i < mobiles.length; i++) {
          String mobile = mobiles[i];
          for (Map.Entry<String, Double> entry : map1.entrySet()) {
            String key = entry.getKey();
            if (mobile.equals(key)) {
              mapAdd.put(key, entry.getValue());
            }

          }

        }
      }
      request.setAttribute("bill", mapAdd);
      RequestDispatcher dispatcher = request.getRequestDispatcher("BillServlet");
      dispatcher.forward(request, response);
    }

  }

}
