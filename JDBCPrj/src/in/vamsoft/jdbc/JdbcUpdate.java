package in.vamsoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class JdbcUpdate {
  public static Logger logger = Logger.getLogger(JdbcUpdate.class);
  
  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter the empid:");
  int empid = sc.nextInt();
  System.out.println("Enter the salary to be increase");
  int amount = sc.nextInt();
  Connection con=null;
  PreparedStatement stmt=null;
  con=DBConnectionUtil.getConnection();
  try {
    stmt=con.prepareStatement("update empcopy set salary=salary+? where empid=?");
    stmt.setInt(1, amount);
    stmt.setInt(2, empid);
    int rows=stmt.executeUpdate();
    System.out.println(rows + "rows updated");
  } catch (SQLException e) {
    e.printStackTrace();
  }finally {
    try {
      stmt.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    DBConnectionUtil.closeConnection(con);
    sc.close();
  }
  
  }
}
