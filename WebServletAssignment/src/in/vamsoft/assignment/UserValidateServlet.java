package in.vamsoft.assignment;

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
    if(name.equals("jk") && password.equals("password")) {
      session.setAttribute("uname", name);
      RequestDispatcher dispatcher = request.getRequestDispatcher("Catalog.html");
      dispatcher.forward(request,response);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher("Error");
      dispatcher.forward(request,response);
    }
    
	}

}
