package in.vamsoft.servlets.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
  Connection con = null;
  ResultSet resultSet = null;
  Customer customer;

  public CustomerDaoImpl() {
    try {
      con = DBConnectionUtil.getConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /* (non-Javadoc)
   * @see in.vamsoft.servlets.dao.CustomerDao#addCustomer(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)
   */
  @Override
  public void addCustomer(Customer c) {

    try (PreparedStatement preparedStatement = con.prepareStatement("insert into customer values(?,?,?,?,?,?)")) {
      LocalDate lDate = LocalDate.parse(c.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

      preparedStatement.setString(1, c.getCustName());
      preparedStatement.setDate(2, Date.valueOf(lDate));
      preparedStatement.setString(3, c.getAddress());
      preparedStatement.setString(4, c.getPhnNo());
      preparedStatement.setString(5, c.getGender());
      preparedStatement.setString(6, c.getHobbies());
      int s = preparedStatement.executeUpdate();
      if (s > 0) {
        System.out.println("Inserted successfully");
      } else {
        System.out.println("not inserted");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  
  /* (non-Javadoc)
   * @see in.vamsoft.servlets.dao.CustomerDao#getAllCustomerDetails()
   */
  @Override
  public List<Customer> getAllCustomerDetails() {
    try (PreparedStatement preparedStatement = con.prepareStatement("select * from customer")){
      List<Customer> list = new ArrayList<>();
      resultSet = preparedStatement.executeQuery();
      while(resultSet.next()) {
        customer = new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4) , resultSet.getString(5), resultSet.getString(6));
        list.add(customer);
      }
      return list;
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
