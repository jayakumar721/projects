package in.vamsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Submitted
 */
public class Submitted extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	@Override
  public void init() throws ServletException {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "password");
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
    PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String phone = request.getParameter("phno");
		String gender = request.getParameter("gender");
		String hobbies = request.getParameter("hobbies");
		System.out.println("Name : " + name + "\nDate of Birth : " + dob + "\n Address : " + address + "\n Phone : "
		    + "" + phone + "\n Gender : " + gender + "\n Hobbies : " +hobbies);
		
		
		try(PreparedStatement preparedStatement=con.prepareStatement("insert into customer values(?,?,?,?,?,?)")){
		  LocalDate lDate = LocalDate.parse((dob),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		  preparedStatement.setString(1, name);
		  preparedStatement.setDate(2,Date.valueOf(lDate));
		  preparedStatement.setString(3, address);
		  preparedStatement.setInt(4, Integer.parseInt(phone));
		  preparedStatement.setString(5, gender);
		  preparedStatement.setString(6, hobbies);
		  int rs = preparedStatement.executeUpdate();
		if(rs > 0) {
		  out.println("Inserted successfull!!");
		} else {
		  out.println("not inserted");
		}
		
		} catch (SQLException e) {
      e.printStackTrace();
    }
		
	}

  
}
