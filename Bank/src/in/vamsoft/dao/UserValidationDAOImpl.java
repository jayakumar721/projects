package in.vamsoft.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import in.vamsoft.model.User;

public class UserValidationDAOImpl {
  Connection connection;
  ResultSet resultSet;

  public UserValidationDAOImpl() {

    connection = DBConnectionUtil.getConnection();
  }

  public boolean getAccountStatus(User user,int accountLockTime) {
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select last_login_time,password_attempts,status from user_data where email_id=?")) {
      preparedStatement.setString(1, user.getEmailId());
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        if (resultSet.getString(3).equals("active")) {
          return true;
        } else {

          Timestamp currentTimeStamp = Timestamp.valueOf(LocalDateTime.now());
          Timestamp existingTimeStamp = resultSet.getTimestamp(1);
          long milliseconds = currentTimeStamp.getTime() - existingTimeStamp.getTime();
          int seconds = (int) milliseconds / 1000;
          if (seconds >= accountLockTime * 60) {
            try (PreparedStatement preparedStatement1 = connection.prepareStatement(
                "update user_data set last_login_time=?,password_attempts=?,status=? where email_id=?")) {
              preparedStatement1.setTimestamp(1, currentTimeStamp);
              preparedStatement1.setInt(2, 0);
              preparedStatement1.setString(3, "active");
              preparedStatement1.setString(4, user.getEmailId());
              int result = preparedStatement1.executeUpdate();
              return result > 0 ? true : false;
            }
          }

        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  public boolean validateUser(User user) {
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select email_id,password from user_data where email_id=?")) {
      preparedStatement.setString(1, user.getEmailId());
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        if ((user.getEmailId().equals(resultSet.getString(1))) && (user.getPassWord().equals(resultSet.getString(2)))) {
          return true;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean getUser(User user) {
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select email_id from user_data where email_id=?")) {
      preparedStatement.setString(1, user.getEmailId());
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        if (user.getEmailId().equals(resultSet.getString(1))) {
          return true;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean createUser(User user) {
    try (PreparedStatement preparedStatement = connection.prepareStatement("insert into user_data values(?,?,?,?,?)")) {
      preparedStatement.setString(1, user.getEmailId());
      preparedStatement.setString(2, user.getPassWord());
      preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
      preparedStatement.setInt(4, 0);
      preparedStatement.setString(5, "active");
      int result = preparedStatement.executeUpdate();
      return result > 0 ? true : false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean invalidPassword(User user,int wrongPasswordAttempts) {

    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select last_login_time,password_attempts,status from user_data where email_id=?")) {
      int passwordAttempts = 0;
      preparedStatement.setString(1, user.getEmailId());
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        if (resultSet.getInt(2) < wrongPasswordAttempts) {
          passwordAttempts = resultSet.getInt(2) + 1;
          try (PreparedStatement preparedStatement1 = connection
              .prepareStatement("update user_data set last_login_time=?,password_attempts=? where email_id=?")) {
            preparedStatement1.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement1.setInt(2, passwordAttempts);
            preparedStatement1.setString(3, user.getEmailId());
            int result = preparedStatement1.executeUpdate();
            return result > 0 ? true : false;
          }
        } else if (resultSet.getInt(2) >= wrongPasswordAttempts) {
          try (PreparedStatement preparedStatement1 = connection
              .prepareStatement("update user_data set last_login_time=?,status=? where email_id=?")) {
            preparedStatement1.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement1.setString(2, "inactive");
            preparedStatement1.setString(3, user.getEmailId());
            @SuppressWarnings("unused")
            int result = preparedStatement1.executeUpdate();
            return false;
          }
        }

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;

  }

}
