package in.vamsoft.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConnectionUtil {

  public static Logger logger = Logger.getLogger(DBConnectionUtil.class);

  public static Connection getConnection() {
    String driver = null;
    String url = null;
    String uName = null;
    String passWord = null;
    Connection connection = null;
    try {
      InputStream reader = DBConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties");
      Properties properties = new Properties();
      properties.load(reader);
      driver = properties.getProperty("driver");
      url = properties.getProperty("url");
      uName = properties.getProperty("user");
      passWord = properties.getProperty("password");
      Class.forName(driver);
      connection = DriverManager.getConnection(url, uName, passWord);
      logger.info("connection done");
    } catch (FileNotFoundException e) {
      logger.error("db properties file not found");
    } catch (ClassNotFoundException e) {

      e.printStackTrace();
    } catch (SQLException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }
    return connection;
  }
  
  public static void closeConnection(Connection conn) {
    try {
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
  }

}
