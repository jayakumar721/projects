package in.vamsoft.assign1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserValidate {
  Connection con = null;
  ResultSet resultSet;
  public UserValidate() {
   
    con = DBConnectionUtil.getConnection();
    
  }
  
  public boolean userValidate(String name, String pass) {
    
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
  
  

}
