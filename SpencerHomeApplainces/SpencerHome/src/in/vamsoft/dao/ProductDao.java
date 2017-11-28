package in.vamsoft.dao;

import in.vamsoft.spencer.DbConnectionUtil;
import in.vamsoft.spencer.Product;
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
public class ProductDao {
  static int invoiceId = 1;

  private Connection connection = null;
  ResultSet rs = null;
  CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

  public ProductDao() {
    connection = DbConnectionUtil.getConnection();
  }

  /**
   * @param e .
   * @return .
   */
  public boolean addProduct(Product e) {

    try (PreparedStatement preparedStatement = connection
        .prepareStatement("insert into product values(?,?,?,?)");) {
      preparedStatement.setInt(1, e.getProduct_id());
      preparedStatement.setString(2, e.getProduct_name());
      preparedStatement.setDouble(3, e.getQuantity());
      preparedStatement.setDouble(4, e.getPrice());
      int inserted = preparedStatement.executeUpdate();
      return inserted > 0 ? true : false;
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return false;
  }

  /**
   * @param pname .
   * @param quantity .
   * @param customerid .
   * @return .
   */
  public boolean bookproduct(String pname, int quantity, int customerid) {

    int productId = 0;

    if (customerDaoImpl.checkCustomerId(customerid)) {
      invoiceId = getLastInvoiceId() + 1;
      try (PreparedStatement preparedStatement = connection
          .prepareStatement("select *  from product where product_name=?");) {
        preparedStatement.setString(1, pname);
        rs = preparedStatement.executeQuery();

        int price;
        int total = 0;
        while (rs.next()) {
          // System.out.println("records"+rs.getInt(1)+" "+rs.next());
          System.out.println("check in invoice");
          productId = rs.getInt(1);
          price = rs.getInt(4);
          total = quantity * price;
          try (
              PreparedStatement preparedStatement1 = connection
                  .prepareStatement("insert into invoice values(?,?,?,?,?,?,?)");
              PreparedStatement preparedStatement3 = connection.prepareStatement("update product "
                  + "set quantity =quantity - ? where product_id=?");) {
            preparedStatement1.setInt(1, invoiceId);
            preparedStatement1.setInt(2, productId);
            preparedStatement1.setString(3, pname);
            preparedStatement1.setInt(4, quantity);
            preparedStatement1.setInt(5, price);
            preparedStatement1.setInt(6, total);
            preparedStatement1.setInt(7, customerid);
            System.out.println(invoiceId + " " + productId + " " + pname + " " 
                  + quantity + " " + price + " " + total);
            int inserted = preparedStatement1.executeUpdate();
            System.out.println(inserted);

            preparedStatement3.setInt(1, quantity);
            preparedStatement3.setInt(2, productId);
            int inserted1 = preparedStatement3.executeUpdate();

            System.out.println(productId + " " + quantity + " " + inserted1);
            return inserted > 0 ? true : false;
          }
        }

      } catch (SQLException e1) {
        e1.printStackTrace();
      }

    }

    return false;
  }

  /**
   * @param pname .
   * @return .
   */
  public int checkProductAvailability(String pname) {
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select * from product where product_name=?")) {
      preparedStatement.setString(1, pname);
      rs = preparedStatement.executeQuery();
      int available = 0;
      while (rs.next()) {
        available = rs.getInt(3);
      }
      return available;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * @return .
   */
  public List<Product> getAllProducts() {
    try (PreparedStatement preparedStatement = connection.prepareStatement(""
        + "select * from Product")) {
      rs = preparedStatement.executeQuery();
      List<Product> products = new ArrayList<>();
      Product product = null;
      while (rs.next()) {
        product = new Product();
        product.setProduct_id(rs.getInt(1));
        product.setProduct_name(rs.getString(2));
        product.setQuantity(rs.getInt(3));
        product.setPrice(rs.getDouble(4));
        products.add(product);
      }
      return products;

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return null;
  }

  /** 
   * @return .
   */
  public int getLastProductId() {
    try (PreparedStatement preparedStatement = connection.prepareStatement(""
        + "select count(*) as count from product");) {
      rs = preparedStatement.executeQuery();
      int lastCount = 0;
      while (rs.next()) {
        lastCount = rs.getInt("count");
      }
      return lastCount;
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return 0;

  }

  /**
   * @return .
   */
  public int getLastInvoiceId() {
    try (PreparedStatement preparedStatement = connection.prepareStatement(""
        + "select count(*) as count from invoice");) {
      rs = preparedStatement.executeQuery();
      int lastCount = 0;
      while (rs.next()) {

        lastCount = rs.getInt("count");
      }
      return lastCount;
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return 0;

  }

}
