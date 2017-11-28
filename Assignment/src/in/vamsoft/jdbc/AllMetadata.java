package in.vamsoft.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AllMetadata {

  public static void main(String[] args) {
    Connection connection = null;
    connection = DBConnectionUtil.getConnection();
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from employees");
      ResultSetMetaData metaData = resultSet.getMetaData();
      DatabaseMetaData data = connection.getMetaData();
      System.out.println(data.getDriverVersion()+"\t"+data.getDriverName()+"\t"+data.getDatabaseProductName()+"\t"+data.getDatabaseProductVersion());
      
      System.out.println(metaData.getColumnCount()+" "+metaData.getColumnName(1));

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
