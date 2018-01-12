package in.vamsoft.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.ForgotPasswordDaoImpl;
import in.vamsoft.dao.UserValidationDAOImpl;
import in.vamsoft.model.User;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  HttpSession session;
  User user;
  UserValidationDAOImpl dao = new UserValidationDAOImpl();
  ForgotPasswordDaoImpl daoImpl = new ForgotPasswordDaoImpl();

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    session = request.getSession();
    String emailId = request.getParameter("emailId");
    String passWord = request.getParameter("password");
    String confrimPassword = request.getParameter("confirmPassword");
    if (passWord.equals(confrimPassword)) {
      user = new User(emailId, passWord);
      boolean result = dao.createUser(user);
      if (result) {
        daoImpl.insertPasswordHistory(user);
        response.getWriter()
        .println("<html><body><script> alert('Registered Successfully!!!') </script></body></html>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
        dispatcher.include(request, response);
      }

    } else {
      response.getWriter()
          .println("<html><body><script> alert('Password and confirm password must be same') </script></body></html>");
      RequestDispatcher dispatcher = request.getRequestDispatcher("newUser.html");
      dispatcher.include(request, response);
    }
  }

}
