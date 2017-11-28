package in.vamsoft.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RuntimeQuery {
  public static void main(String[] args) {
    Connection connection = null;
    connection = DBConnectionUtil.getConnection();
    System.out.println("Enter the query");
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    String query = sc.nextLine();
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet=null;
      if (query.contains("select")) {
        
         resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
          System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
        }
      } else {
          int s = statement.executeUpdate(query);
          System.out.println(s + "rows updated");
          
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
