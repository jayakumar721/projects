package in.vamsoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreationOfTable {
  public static void main(String[] args) {
    Connection connection = null;
    connection = DBConnectionUtil.getConnection();
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("create table jk (no number(10),name varchar2(10))")) {
      preparedStatement.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
