package in.vamsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.vamsoft.model.User;

public class UserImpl implements UserDAO {
  Connection connection = null;
  ResultSet resultSet = null;
  public UserImpl() {
    connection = DBConnectionUtil.getConnection();
  }

  /* (non-Javadoc)
   * @see in.vamsoft.dao.UserDAO#userValidate(in.vamsoft.model.User)
   */
  @Override
  public boolean userValidate(User user) {

    try(PreparedStatement preparedStatement = connection.prepareStatement("select emailid,password from test_user")){
      resultSet = preparedStatement.executeQuery();
      while(resultSet.next()) {
        if(resultSet.getString(1).equals(user.getEmail())&&resultSet.getString(2).equals(user.getPassword())) {
          return true;
        }
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return false;
  }
  
  /* (non-Javadoc)
   * @see in.vamsoft.dao.UserDAO#getUserName(in.vamsoft.model.User)
   */
  @Override
  public String getUserName(User user) {
    try(PreparedStatement preparedStatement = connection.prepareStatement("select firstname from test_user where emailid=?")){
      preparedStatement.setString(1, user.getEmail());
      resultSet = preparedStatement.executeQuery();
      
      while(resultSet.next()) {
        return resultSet.getString(1);
      }
      
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return null;
    
  }
  
  /* (non-Javadoc)
   * @see in.vamsoft.dao.UserDAO#userRegistration(in.vamsoft.model.User)
   */
  @Override
  public boolean userRegistration(User user) {
    
    try(PreparedStatement preparedStatement = connection.prepareStatement("insert into test_user values(user_sequence.nextval,?,?,?,?)")){
      preparedStatement.setString(1, user.getEmail());
      preparedStatement.setString(2, user.getFirstname());
      preparedStatement.setString(3, user.getLastname());
      preparedStatement.setString(4, user.getPassword());
      int result = preparedStatement.executeUpdate();
      return result>0?true:false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return false;
    
  }
  
  /* (non-Javadoc)
   * @see in.vamsoft.dao.UserDAO#verifyUser(java.lang.String)
   */
  @Override
  public boolean verifyUser(String email) {
    
    try(PreparedStatement preparedStatement = connection.prepareStatement("select emailid from test_user")){
      
      resultSet = preparedStatement.executeQuery();
      while(resultSet.next()) {
        if(email.equals(resultSet.getString(1))) {
          return true;
        }
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return false;
    
  }
  
  /* (non-Javadoc)
   * @see in.vamsoft.dao.UserDAO#updatePassword(in.vamsoft.model.User)
   */
  @Override
  public boolean updatePassword(User user) {
    try(PreparedStatement preparedStatement = connection.prepareStatement("update test_user set password=? where emailid=?")){
      
      preparedStatement.setString(1, user.getPassword());
      preparedStatement.setString(2, user.getEmail());
      int result = preparedStatement.executeUpdate();
      return result>0?true:false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return false;
    
  }
  
}
