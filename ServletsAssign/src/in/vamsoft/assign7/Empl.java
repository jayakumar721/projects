package in.vamsoft.assign7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.assign1.DBConnectionUtil;

public class Empl {
  Connection connection = null;
  public Empl() {
   connection = DBConnectionUtil.getConnection();
  }
  
  public List<DemoBean> emp(){
    List<DemoBean> list = new ArrayList<>();
    DemoBean bean=null;
    try(PreparedStatement preparedStatement = connection.prepareStatement("select * from emp1")){
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next()) {
        bean = new DemoBean();
        bean.setName(resultSet.getString(1));
        bean.setAge(resultSet.getInt(2));
        list.add(bean);
        System.out.println(list);
      }
      return list;
        
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
