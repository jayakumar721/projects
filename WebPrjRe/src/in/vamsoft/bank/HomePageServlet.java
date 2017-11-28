package in.vamsoft.bank;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object name = session.getAttribute("name");
		PrintWriter out = response.getWriter();
		if(name==null) {
		  response.sendRedirect("BankIndex.html");
		} else {
		  String sName = name.toString();
		  out.println("<html><body><h1>Welcome"+sName+"</h1><br>");
		  out.println("<a href ='TransferFundServlet'>TransferFunds</a>");
		  out.println("</body></html>");
		}
	}

}
