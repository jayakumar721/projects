package in.vamsoft.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetadataCount {
  public static void main(String[] args) {
    Connection connection = null;
    connection = DBConnectionUtil.getConnection();
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from employees");
      ResultSetMetaData metaData = resultSet.getMetaData();
      System.out.println(metaData.getColumnCount()+" "+metaData.getColumnName(1)+" "+metaData.getColumnName(2));
      
      while(resultSet.next()) {
        System.out.println(metaData.getColumnTypeName(2));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
