package in.vamsoft.service;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.UserValidationDAOImpl;
import in.vamsoft.model.User;

/**
 * Servlet implementation class UserValidationServlt
 */
@WebServlet("/UserValidationServlet")
public class UserValidationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  HttpSession session;
  User user;
  UserValidationDAOImpl dao = new UserValidationDAOImpl();
  static int count = 0;

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    @SuppressWarnings("unused")
    PrintWriter out = response.getWriter();
    session = request.getSession();
    int accountLockTimeOut=Integer.parseInt(getServletContext().getInitParameter("accountLockTimeOut"));
    int wrongPasswordAttempts=Integer.parseInt(getServletContext().getInitParameter("wrongPasswordAttempts"));

    String emailId = request.getParameter("emailId");
    String passWord = request.getParameter("password");
    user = new User(emailId, passWord);
    boolean userExists = dao.getUser(user);
    
    if(userExists) {
    boolean accountStatus = dao.getAccountStatus(user,accountLockTimeOut);
   
    if (accountStatus) {
      boolean userReturn = dao.validateUser(user);
      if (userReturn) {
        session.setAttribute("emailId",emailId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.include(request, response);
      
      } else {
        boolean result = dao.invalidPassword(user,wrongPasswordAttempts);
        if (result) {
          response.getWriter().println(
              "<html><body><script> alert('incorect Password') </script></body></html>");
          RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
          dispatcher.include(request, response);
        } else {
          response.getWriter().println(
              "<html><body><script> alert('Account is Locked try after 10 minutes') </script></body></html>");
          RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
          dispatcher.include(request, response);
        }
      }
    } else {
      response.getWriter()
          .println("<html><body><script> alert('your account is locked try after some time') </script></body></html>");
      RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
      dispatcher.include(request, response);
    }
    }else {
      response.getWriter()
      .println("<html><body><script> alert('Invalid Email ID') </script></body></html>");
      RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
      dispatcher.include(request, response);      
    }
  }

}
