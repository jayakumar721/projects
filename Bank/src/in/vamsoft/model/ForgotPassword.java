package in.vamsoft.model;

import java.sql.Timestamp;

public class ForgotPassword {
  
  private String emailId;
  private Timestamp date;
  private int otp;
  
  public ForgotPassword() {}
  
  public ForgotPassword(String emailId, Timestamp date, int otp) {
    super();
    this.emailId = emailId;
    this.date = date;
    this.otp = otp;
  }

  public String getEmailId() {
    return emailId;
  }
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
  public Timestamp getDate() {
    return date;
  }
  public void setDate(Timestamp date) {
    this.date = date;
  }
  public int getOtp() {
    return otp;
  }
  public void setOtp(int otp) {
    this.otp = otp;
  }
  
  
  
  @Override
  public String toString() {
    return "ForgetPassword [emailId=" + emailId + ", date=" + date + ", otp=" + otp + "]";
  }
  
  
  
  
  

}
