package in.vamsoft.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.UserDAO;
import in.vamsoft.dao.UserImpl;
import in.vamsoft.model.User;

/**
 * Servlet implementation class UserValidateServlet
 */
@WebServlet("/UserValidateServlet")
public class UserValidateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  UserDAO dao = new UserImpl();
  HttpSession session;
  User user;
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String option = request.getParameter("option");
    if (option.equals("login")) {
      String email = request.getParameter("username");
      String password = request.getParameter("password");
      user = new User(email, password);
      boolean validate = dao.userValidate(user);
      if (validate) {
        String name = dao.getUserName(user);
        session = request.getSession();
        session.setAttribute("name", name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.include(request, response);
      } else {
        response.getWriter().println("<html><body><h3 style=color:red>Wrong Cridentials</h3></body></html>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
        dispatcher.include(request, response);
      }
    } else if (option.equals("Sign up")) {
      String emailid = request.getParameter("email");
      String fname = request.getParameter("firstname");
      String lname = request.getParameter("lastname");
      String password = request.getParameter("password");
      user = new User(emailid, password);
      user.setFirstname(fname);
      user.setLastname(lname);
      
      boolean add = dao.userRegistration(user);
      if(add) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
        dispatcher.forward(request, response);
      } else {
        System.out.println("not inserted");
      }
    } else if (option.equals("forgot")) {
      String email = request.getParameter("email");
      boolean valid = dao.verifyUser(email);
      if(valid) {
        session = request.getSession();
        session.setAttribute("email", email);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reset.jsp");
        dispatcher.forward(request, response);
      } else {
        response.getWriter().println("<html><body><p style=color:red;>Invalid email id<p></body></html>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("forgotpassword.html");
        dispatcher.include(request, response);
      }
    } else if(option.equals("reset")) {
      String email = (String) session.getAttribute("email");
      String password = request.getParameter("password");
      user = new User(email, password);
      boolean success = dao.updatePassword(user);
      if(success) {
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
        dispatcher.forward(request, response);
      }
      
    }
  }

}
