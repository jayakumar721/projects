package in.vamsoft.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class JDBCPrj {

  public static Logger logger = Logger.getLogger(JDBCPrj.class);

  public static void main(String[] args) {
    logger.info("main method started");
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      con = DBConnectionUtil.getConnection();
      logger.info("connection ok");
      stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
      rs = stmt.executeQuery("select empid,fname,salary,doj,deptid from empcopy");
      ResultSetMetaData data = rs.getMetaData();
      int colcount = data.getColumnCount();
      System.out.println("\n------------------------------------------------------------------------------");
      for(int i=1;i<=colcount;i++) {
        System.out.print(data.getColumnName(i)+"\t\t");
      }
      System.out.println("\n------------------------------------------------------------------------------");
      while (rs.next()) {
        System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getDate(4)
            + "\t\t" + rs.getInt(5));
      }
      System.out.println("going back");
      rs.previous();
      System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getDate(4)
      + "\t\t" + rs.getInt(5));
      System.out.println();
      rs.first();
      rs.absolute(2);
      rs.updateInt(5, 66);
      rs.updateRow();
      System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getDate(4)
      + "\t\t" + rs.getInt(5));
      
    } catch (SQLException e) {
      
      e.printStackTrace();
    } finally {
      try {
        rs.close();
        stmt.close();
        con.close();
      } catch (SQLException e) {
        
        e.printStackTrace();
      }
    }
  }
}
