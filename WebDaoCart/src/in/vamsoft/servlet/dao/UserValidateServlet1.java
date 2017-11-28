package in.vamsoft.servlet.dao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserValidateServlet1")
public class UserValidateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;
	CartDao daoImpl;
	UserLogin login;
	
	
	@Override
  public void init() throws ServletException {
	  daoImpl = new CartDaoImpl();
  }



  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    session = request.getSession();
    String name = request.getParameter("uname");
    String password = request.getParameter("pass");
    Boolean connection = daoImpl.verifyCustomer(name,password);
    if(connection==true) {
      session.setAttribute("uname", name);
      login=new UserLogin(name, password);
      RequestDispatcher dispatcher = request.getRequestDispatcher("CartDaoCatlog.html");
      dispatcher.forward(request,response);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher("Error");
      dispatcher.forward(request,response);
    }
   
    
	}

}
