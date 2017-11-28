package in.vamsoft.dao;

import in.vamsoft.spencer.Customer;
import in.vamsoft.spencer.DbConnectionUtil;
import in.vamsoft.spencer.Invoice;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 * @author vamsoft .
 *
 */
public class CustomerDaoImpl {
  private Connection connection = null;
  ResultSet resultSet = null;

  public CustomerDaoImpl() {
    connection = DbConnectionUtil.getConnection();
  }

  /**
   * @param e customer details as object for adding customer.
   * @return true if customer added else false
   */
  public boolean addCustomer(Customer e) {

    try (PreparedStatement preparedStatement = connection.prepareStatement(""
        + "insert into customer values(?,?,?)");) {
      preparedStatement.setInt(1, e.getCustId());
      preparedStatement.setString(2, e.getName());
      preparedStatement.setDouble(3, e.getContactNo());
      int inserted = preparedStatement.executeUpdate();
      return inserted > 0 ? true : false;
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return false;
  }

  /**
   * @return returns the lastcustomer id from customer table.
   */
  public int getLastCustomerId() {
    try (PreparedStatement preparedStatement = connection.prepareStatement(""
        + "select count(*) as count from customer");) {
      resultSet = preparedStatement.executeQuery();
      int lastCount = 0;
      while (resultSet.next()) {

        lastCount = resultSet.getInt("count");
      }
      return lastCount;
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return 0;

  }

  /**
   * @param customerId for getting customerId.
   * @return whether the given customerId is available in the table
   */
  public boolean checkCustomerId(int customerId) {

    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select customer_id from customer where customer_id=?");) {
      preparedStatement.setInt(1, customerId);

      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        return true;
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return false;

  }

  /**
   * @param custId for getting customer id.
   * @return returns all booked products.
   */
  public List<Invoice> getAllBookedProducts(int custId) {

    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select * from invoice where customer_id=?")) {
      preparedStatement.setInt(1, custId);
      resultSet = preparedStatement.executeQuery();
      List<Invoice> invoices = new ArrayList<>();
      Invoice invoice = null;
      while (resultSet.next()) {
        invoice = new Invoice();
        invoice.setInvoiceId(resultSet.getInt(1));
        invoice.setProductId(resultSet.getInt(2));
        invoice.setProductName(resultSet.getString(3));
        invoice.setQuantity(resultSet.getInt(4));
        invoice.setProductPrice(resultSet.getInt(5));
        invoice.setTotal(resultSet.getInt(6));
        invoices.add(invoice);
      }
      return invoices;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

}
