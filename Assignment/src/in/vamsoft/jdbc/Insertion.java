package in.vamsoft.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertion {

  public static void main(String[] args) {

    Connection connection = DBConnectionUtil.getConnection();
    try (PreparedStatement statement = connection.prepareStatement("insert into jk values(?,?)")) {
      System.out.println("enter no of insertions:");
      @SuppressWarnings("resource")
      Scanner scanner = new Scanner(System.in);
      @SuppressWarnings("resource")
      Scanner scanner1 = new Scanner(System.in);
      int a= scanner.nextInt();
      for(int i=0;i<a;i++) {
        System.out.println("enter no:");
        int no = scanner.nextInt();
        System.out.println("enter name:");
        String name = scanner1.nextLine();
        statement.setInt(1, no);
        statement.setString(2, name);
        statement.executeQuery();
        System.out.println("1 row inserted");
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
