package in.vamsoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmp {

  public static void main(String[] args) {
    Connection connection=null;
    connection = DBConnectionUtil.getConnection();
    try(PreparedStatement preparedStatement = connection.prepareStatement("select * from employees")){
      
      
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next()) {
       System.out.println(resultSet.getInt(1) +"\t"+ resultSet.getString(2)+"\t"+resultSet.getString(3));
      }
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
