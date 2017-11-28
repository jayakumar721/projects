package in.vamsoft.servlets.dao;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;



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
  CustomerDaoImpl impl;

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */

  @Override
  public void init() throws ServletException {
    impl = new CustomerDaoImpl();
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
    System.out.println("Name : " + name + "\nDate of Birth : " + dob + "\n Address : " + address + "\n Phone : " + ""
        + phone + "\n Gender : " + gender + "\n Hobbies : " + hobbies);

    Customer customer = new Customer(name, dob, address, phone, gender, hobbies);
    impl.addCustomer(customer);

  }

}
