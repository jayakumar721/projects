package in.vamsoft.assign4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.assign1.DBConnectionUtil;

public class EmpDao {

  Connection connection;
  public EmpDao() {
    connection = DBConnectionUtil.getConnection();
  }

  public List<Emp> getRecords(int start, int total) {
    List<Emp> list = new ArrayList<Emp>();
    try (PreparedStatement ps =connection.prepareStatement("SELECT * from(select m.*, rownum r from employees m) where r > ? and r < ?") ) {
      ps.setInt(1, start-1);
      ps.setInt(2, total+start);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Emp e = new Emp();
        e.setId(rs.getInt(1));
        e.setName(rs.getString(2));
        e.setSalary(rs.getFloat(8));
        list.add(e);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return list;
  }
}