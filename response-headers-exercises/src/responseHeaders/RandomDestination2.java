package responseHeaders;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/random-destination2")
public class RandomDestination2 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    if (Math.random() < 0.5) {
      response.setStatus(302);
      response.setHeader("Location", "http://www.mozilla.org");
    } else {
      response.setStatus(302);
      response.setHeader("Location", "http://www.microsoft.com");
    }
  }
}
