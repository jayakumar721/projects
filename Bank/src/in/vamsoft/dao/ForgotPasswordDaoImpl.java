package in.vamsoft.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import in.vamsoft.model.ForgotPassword;
import in.vamsoft.model.User;
import oracle.net.nt.NTAdapter;

public class ForgotPasswordDaoImpl {

  Connection connection;
  ResultSet resultSet;

  public ForgotPasswordDaoImpl() {
    connection = DBConnectionUtil.getConnection();
  }

  public boolean generateOTP(ForgotPassword forgotPassword) {

    try (PreparedStatement preparedStatement = connection
        .prepareStatement("insert into forgot_password values(?,?,?)")) {
      preparedStatement.setString(1, forgotPassword.getEmailId());
      preparedStatement.setTimestamp(2, forgotPassword.getDate());
      preparedStatement.setInt(3, forgotPassword.getOtp());
      @SuppressWarnings("unused")
      int result = preparedStatement.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public Timestamp getTimestamp(String emailId) {
    Timestamp existingTimestamp = null;
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select otp_generation_time from forgot_password where email_id=?")) {
      preparedStatement.setString(1, emailId);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        existingTimestamp = resultSet.getTimestamp(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return existingTimestamp;
  }

  @SuppressWarnings("unused")
  public boolean resetPassword(User user, int otp) {
    try (PreparedStatement preparedStatement = connection
        .prepareStatement("select email_id,otp_generation_time,otp from forgot_password where email_id=?")) {
      preparedStatement.setString(1, user.getEmailId());
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        if (resultSet.getString(1).equals(user.getEmailId()) && resultSet.getInt(3) == otp) {
          try (PreparedStatement preparedStatement1 = connection
              .prepareStatement("update user_data set password=? where email_id=?")) {
            preparedStatement1.setString(2, user.getEmailId());
            preparedStatement1.setString(1, user.getPassWord());
            int result = preparedStatement1.executeUpdate();
            return true;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @SuppressWarnings("unused")
  public boolean cleanOTPTable(String uName) {
    try (PreparedStatement preparedStatement2 = connection
        .prepareStatement("delete from forgot_password where email_id=?")) {
      preparedStatement2.setString(1, uName);
      int result = preparedStatement2.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public boolean sendMail(String emailId, int otp) {

    final String user = "myhflproject@gmail.com";
    final String password = "myhflproject1";

    // 1) get the session object
    Properties properties = new Properties();
    // properties.setProperty("mail.smtp.host", "smtp.gmail.com");
    // properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.socketFactory.port", "465");
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password);
      }
    });

    // 2) compose message
    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(user));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
      message.setSubject("OTP for changing the Password");

      // 3) create MimeBodyPart object and set your message text
      BodyPart messageBodyPart1 = new MimeBodyPart();
      messageBodyPart1.setText("Hi ,\n\tThis is your OTP for changing the password:" + otp);

      // 5) create Multipart object and add MimeBodyPart objects to this object
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart1);

      // 6) set the multipart object to the message object
      message.setContent(multipart);

      // 7) send message
      Transport.send(message);

      System.out.println("message sent....");
      return true;
    } catch (MessagingException ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @SuppressWarnings("unused")
  public boolean changePassword(User user) {

    try (PreparedStatement preparedStatement1 = connection
        .prepareStatement("update user_data set password=? where email_id=?")) {
      preparedStatement1.setString(2, user.getEmailId());
      preparedStatement1.setString(1, user.getPassWord());
      int result = preparedStatement1.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public List<String> getLastTenPasswords(String emailId, int passwordCount) {

    List<String> lastTenPasswords = new ArrayList<>();
    System.out.println("inside the getLastTenPasswords");
    try (PreparedStatement ps = connection.prepareStatement(
        "SELECT password FROM password_history where email =? " + "order by password_history_id desc LIMIT " +passwordCount+"")) {

      ps.setString(1, emailId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        lastTenPasswords.add(rs.getString(1));
      }

    } catch (SQLException e) {
      System.out.println("SQLException"+e);
    }
    return lastTenPasswords;

  }
  
  public boolean insertPasswordHistory(User user) {
    System.out.println("inside pass dao");
    try (PreparedStatement ps = connection
        .prepareStatement("insert into password_history(login_date,email,"
            + "password) values(?,?,?)")) {

      ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));  
      ps.setString(2, user.getEmailId());
      ps.setString(3, user.getPassWord());
      int rows = ps.executeUpdate();
      if (rows > 0) {
        System.out.println("inserted row");
      } else {
        System.err.println("not inserted row");
      }

    } catch (SQLException e) {      
      System.out.println("syntax error on query pass dao" + e);
    }
    return false;
  }

}
