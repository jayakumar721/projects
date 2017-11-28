package in.vamsoft.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CartDaoImpl implements CartDao {

  Connection con;
  ResultSet resultSet;

  public CartDaoImpl() {

    con = DBConnectionUtil.getConnection();

  }

  /*
   * (non-Javadoc)
   * 
   * @see in.vamsoft.servlet.dao.CartDao#verifyCustomer(java.lang.String,
   * java.lang.String)
   */
  @Override
  public boolean verifyCustomer(String name, String pass) {

    try (PreparedStatement preparedStatement = con.prepareStatement("select * from login")) {

      resultSet = preparedStatement.executeQuery();
      String uname;
      String password;
      while (resultSet.next()) {
        uname = resultSet.getString(1);
        password = resultSet.getString(2);
        if (uname.equals(name) && password.equals(pass)) {
          return true;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see in.vamsoft.servlet.dao.CartDao#cart(java.lang.String[],
   * java.lang.String[])
   */
  @Override
  public Map<String, Double> cart(String bear[], String mobiles[]) {
    System.out.println(bear.toString()+" "+mobiles.toString());
    try (PreparedStatement preparedStatement = con.prepareStatement("select * from bear union all select * from mobile");) {
      String productName;
      Double productPrice;
      Map<String, Double> addMap = new HashMap<>();
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        productName = resultSet.getString(1);
        productPrice = resultSet.getDouble(2);
        if (bear.length > 0 || mobiles.length > 0) {
          for (int i = 0; i < bear.length; i++) {
            String bears=bear[i];
            if (bears.equals(productName)) {
              addMap.put(productName, productPrice);
            }
          }
          for (int i = 0; i < mobiles.length; i++) {
            String mobile = mobiles[i];
            if (mobile.equals(productName)) {
              addMap.put(productName, productPrice);
            }

          }

        }
      }
      return addMap;

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;

  }

}
