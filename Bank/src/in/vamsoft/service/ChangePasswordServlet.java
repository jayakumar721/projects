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
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  HttpSession session;
  User user;
  User user1;

  UserValidationDAOImpl daoImpl = new UserValidationDAOImpl();
  ForgotPasswordDaoImpl dao = new ForgotPasswordDaoImpl();

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    session = request.getSession();
 
    int passwordCount=Integer.parseInt(getServletContext().getInitParameter("lastPasswordCount"));
    
    String emailId = (String) session.getAttribute("emailId");
    String oldPassword = request.getParameter("oldPassword");
    String passWord = request.getParameter("Password");
    String confrimPassword = request.getParameter("confirmPassword");
    System.out.println(emailId+","+oldPassword+","+passWord);
    user1 = new User(emailId, oldPassword);
    if (daoImpl.validateUser(user1)) {
      if (passWord.equals(confrimPassword)) {
        user = new User(emailId, oldPassword);
        List<String> lastTenPasswords = dao.getLastTenPasswords(emailId,passwordCount);
        System.out.println(lastTenPasswords+"last password count-------------");
        if (!lastTenPasswords.contains(passWord)) {
          boolean change = dao.changePassword(user);
          if (change) {
            dao.insertPasswordHistory(user);
            response.getWriter()
                .println("<html><body><script> alert('password changed Successfully!!!') </script></body></html>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.include(request, response);
          }
        } else {
          response.getWriter()
              .println("<html><body><script> alert('you cant use last "+passwordCount+" passwords') </script></body></html>");
          RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
          dispatcher.include(request, response);
        }
      } else {
        response.getWriter().println(
            "<html><body><script> alert('Password and confirm password must be same') </script></body></html>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.include(request, response);
      }
    } else {
      response.getWriter().println("<html><body><script> alert('Old password doesnt match') </script></body></html>");
      RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
      dispatcher.include(request, response);
    }
  }

}
