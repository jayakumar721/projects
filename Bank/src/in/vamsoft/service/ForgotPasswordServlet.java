package in.vamsoft.service;

import java.io.IOException;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.ForgotPasswordDaoImpl;
import in.vamsoft.dao.UserValidationDAOImpl;
import in.vamsoft.model.ForgotPassword;
import in.vamsoft.model.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
  User user = new User();
  UserValidationDAOImpl dao = new UserValidationDAOImpl();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  session= request.getSession();
    String emailId = request.getParameter("emailId");
    user.setEmailId(emailId);
    boolean userExists = dao.getUser(user);
	  if(userExists) {
	    Random rnd = new Random();
	    int otp = 100000 + rnd.nextInt(900000);
	    Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
	    ForgotPassword forgotPassword = new ForgotPassword(emailId,timestamp,otp);
	    ForgotPasswordDaoImpl daoImpl = new ForgotPasswordDaoImpl();
	    
	  
	    
	    boolean result = daoImpl.generateOTP(forgotPassword);
	    boolean mailStatus= daoImpl.sendMail(emailId, otp);
	    if(result) {
	      session.setAttribute("emailId", emailId);
	      if(mailStatus) {
	        response.sendRedirect("resetPassword.jsp");   
	      }
	      else {
	        response.getWriter()
          .println("<html><body><script> alert('Please Generate OTP Again,connection problem') </script></body></html>");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.html");
	        dispatcher.include(request, response);
	      }
	    }
	    
	  } else {
	    response.getWriter()
      .println("<html><body><script> alert('Invalid Email ID') </script></body></html>");
      RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.html");
      dispatcher.include(request, response);
	  }
	
	}

}
