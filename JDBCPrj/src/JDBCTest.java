import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
  public static void main(String[] args) {
    try {
      Class.forName("org.postgresql.Driver");
      Connection connection = null;
      connection = DriverManager.getConnection("jdbc:postgresql://192.168.10.123:5432/vamsoftdb","sivavam", "Siv@123");
      System.out.println("ok");
      connection.close();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}
