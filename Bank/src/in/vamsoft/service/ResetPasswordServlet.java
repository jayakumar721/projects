package in.vamsoft.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.ForgotPasswordDaoImpl;
import in.vamsoft.model.User;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  HttpSession session;
  User user = new User();
  ForgotPasswordDaoImpl dao = new ForgotPasswordDaoImpl();

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    session = request.getSession();
    int passwordCount=Integer.parseInt(getServletContext().getInitParameter("lastPasswordCount"));
    // boolean result=false;
    String emailId = (String) session.getAttribute("emailId");
    int otp = Integer.parseInt(request.getParameter("otp"));
    String password = request.getParameter("Password");
    String confirmpassword = request.getParameter("confirmPassword");
    if (password.equals(confirmpassword)) {
      user = new User(emailId, password);
      Timestamp existingTimeStamp = dao.getTimestamp(emailId);
      Timestamp currentTimeStamp = Timestamp.valueOf(LocalDateTime.now());
      long milliseconds = currentTimeStamp.getTime() - existingTimeStamp.getTime();
      int seconds = (int) milliseconds / 1000;
      // int minutes = (seconds % 3600) / 60;
      int otpTimeOut=Integer.parseInt(getServletContext().getInitParameter("otpTimeout"));
      System.out.println(seconds);
      if (seconds <= otpTimeOut*60) {
        List<String> lastTenPasswords = dao.getLastTenPasswords(emailId,passwordCount);
        System.out.println(lastTenPasswords);
        if (!lastTenPasswords.contains(password)) {
          dao.insertPasswordHistory(user);
          boolean result = dao.resetPassword(user, otp);
          if (result) {
            dao.cleanOTPTable(emailId);
            response.getWriter().println("<html><body><script> alert('reset successfull!!') </script></body></html>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
            dispatcher.include(request, response);
          } else {

            response.getWriter().println("<html><body><script> alert('Invalid OTP') </script></body></html>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.jsp");
            dispatcher.include(request, response);
          }
        } else {
          response.getWriter().println("<html><body><script> alert('you can't use last passwords') </script></body></html>");
          RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.jsp");
          dispatcher.include(request, response);          
        }

      } else {
        dao.cleanOTPTable(emailId);
        response.getWriter()
            .println("<html><body><script> alert('OTP time out Please Generate OTP Again') </script></body></html>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.html");
        dispatcher.include(request, response);
      }

    } else {
      response.getWriter()
          .println("<html><body><script> alert('Password and confirm password must be same') </script></body></html>");
      RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.jsp");
      dispatcher.include(request, response);
    }

  }

}
