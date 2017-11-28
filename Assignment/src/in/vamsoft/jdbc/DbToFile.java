package in.vamsoft.jdbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbToFile {
  
  public static void main(String[] args) {
    try {
      @SuppressWarnings("resource")
      FileOutputStream fos = new FileOutputStream("te.txt");
      Connection connection = DBConnectionUtil.getConnection();
      Statement statement = connection.createStatement();
      ResultSet set = statement.executeQuery("select first_name from employees");
      while(set.next()) {
        String empData = set.getString(1);
        byte[] data = empData.getBytes();
        fos.write(data);
        fos.write(System.getProperty("line.separator").getBytes());
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

}
