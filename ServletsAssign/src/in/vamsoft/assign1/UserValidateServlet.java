package in.vamsoft.assign1;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserValidateServlet")
public class UserValidateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  HttpSession session;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    session = request.getSession();
    String name = request.getParameter("uname");
    String password = request.getParameter("pass");
    UserValidate validate = new UserValidate();
    boolean valid = validate.userValidate(name, password);
    if (valid) {
      session.setAttribute("name", name);
      RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
      dispatcher.forward(request, response);
    } else {
      response.getWriter().println("<html><body><h3 style=color:red>Wrong Cridentials</h3></body></html>");
      RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
      dispatcher.include(request, response);
    }

  }

}
