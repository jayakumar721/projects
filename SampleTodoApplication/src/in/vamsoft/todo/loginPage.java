package in.vamsoft.todo;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Random;

import javax.servlet.Registration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import in.vamsof.servicepackagetodo.ServiceTodo;
import in.vamsof.servicepackagetodo.TodoInter;
import in.vamsoft.todopojos.RegistrationPojos;
import in.vamsoft.todopojos.TaskPojo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/loginPage")
public class loginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter printWriter = response.getWriter();
		 String operation =request.getParameter("operation");
		 if(operation.equals("Registration")) {
			 
		
			 String email=request.getParameter("email");
		
			 TodoInter inter = new ServiceTodo();
			 boolean checkEmail = inter.checkEmailAvailabilty(email);
			 if(checkEmail) {
				 response.getWriter().write("Email already Exits");
			 }
			 else {
				 String name=request.getParameter("name");
				 String emaiL1=request.getParameter("email");
				 String encodedPassword=request.getParameter("encodedPassword");
				 char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
				 StringBuilder sb = new StringBuilder();
				 Random random = new Random();
				 for (int i = 0; i < 20; i++) {
				     char c = chars[random.nextInt(chars.length)];
				     sb.append(c);
				 }
				 String emailHashcode = sb.toString();
				 System.out.println(emailHashcode);
				 RegistrationPojos pojos = new RegistrationPojos(name, emaiL1, encodedPassword,emailHashcode);
				 TodoInter inter1 = new ServiceTodo();
				 String addUser = inter.addUser(pojos);
				 response.getWriter().write(addUser);
			 }
		 }
		 else if(operation.equals("Login")) {
			 String email=request.getParameter("email");
			 String encodedPassword=request.getParameter("encodedPassword");
			 byte[] decoder =Base64.decode(encodedPassword);
			 String password = new String(decoder);
			
			 RegistrationPojos pojos = new RegistrationPojos(email, password);
			 TodoInter inter = new ServiceTodo();
			 int addUser = inter.Checkpassword(pojos);
			 if((addUser!=1)&(addUser!=0)) {
				 	response.getWriter().write("CorrectLogin");
				 	HttpSession	httpSession = request.getSession();
					httpSession.setAttribute("addUser", addUser);
					
			 }
			 else if((addUser==1)) {
				 response.getWriter().write("Email id is not registered");
			 }
			 else if((addUser==0)) {
				 response.getWriter().write("Password is not correct");
			 }
			 
		 }
	}

}
