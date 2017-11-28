package in.vamsoft.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import in.vamsoft.jdbc.DBConnectionUtil;

public class BatchDemo {

  public static void main(String[] args) {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String answer=null;
    try (Connection con = DBConnectionUtil.getConnection();PreparedStatement ps = con.prepareStatement("insert into empcopy values(?,?,?,?,?)");) {
      
      System.out.println("Enter employee details to insert into db");
      do {
      System.out.println("empid");
      int empId = Integer.parseInt(bufferedReader.readLine());

      System.out.println("empname");
      String empName = bufferedReader.readLine();

      System.out.println("Salary");
      int empSalary = Integer.parseInt(bufferedReader.readLine());

      System.out.println("DOJ");
      LocalDate doj = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

      System.out.println("DeptId");
      int DeptId = Integer.parseInt(bufferedReader.readLine());
      
      ps.setInt(1, empId);
      ps.setString(2, empName);
      ps.setInt(3, empSalary);
      ps.setDate(4, Date.valueOf(doj));
      ps.setInt(5, DeptId);
      System.out.println("Enter yes to add more");
      answer = bufferedReader.readLine();
      ps.addBatch();
      }while(answer.equals("yes"));
      int[] rows = ps.executeBatch();
      for(int row:rows) {
        if(row !=0) {
          System.out.println(row + "rows inserted");
        }else {
          System.out.println("not inserted");
        }
        
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
